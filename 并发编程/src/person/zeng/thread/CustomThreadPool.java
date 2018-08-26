package person.zeng.thread;
/**
 * 自定义一个线程池，参照ThreadPoolExecutors;
 * 
 * @author Administrator
 *
 */

import java.util.concurrent.BlockingQueue;

public class CustomThreadPool {
  private volatile int usedThreadCount = 0;
  private int corePoolSize;
  private int maxPoolSize;
  private long aliveTime;// 同一时间为毫秒
  private BlockingQueue<Runnable> queue;

  public CustomThreadPool(int corePoolSize, int maxPoolSize, long aliveTime,
      BlockingQueue<Runnable> queue) {
    super();
    this.corePoolSize = corePoolSize;
    this.maxPoolSize = maxPoolSize;
    this.aliveTime = aliveTime;
    this.queue = queue;
    for (int i = 0; i < corePoolSize; i++) {
      Thread coreThread = new CoreThread(queue);
      coreThread.setName("coreThread_" + i);
      coreThread.start();
    }
  }

  /**
   * 1.向线程池提交任务，如果>任务数量maxPoolSize>corePool,则将任务添加到任务队列中 2.创建新的线程来处理任务队列中的任务
   * 3.如果任务队列满了，并且线程池中所有线程都在工作，这个时候还有任务的话就开始拒绝任务添加（4中拒绝策略）
   * 
   * @param r
   * @throws Exception
   */
  public void submit(Runnable r) throws Exception {
    try {
      queue.put(r);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (getPoolSize() > maxPoolSize - corePoolSize) {// 核心线程还没有用完，将任务交给核心线程去执行
      usedThreadCount++;
    } else if (getPoolSize() <= maxPoolSize - corePoolSize) {// 将任务放入队列中去,新建线程来处理
      Thread thread = new TempThread(queue);
      thread.setName("tempThread_" + (usedThreadCount + 1));
      usedThreadCount++;
    } else if (getPoolSize() <= 0) {
      throw new Exception("已经没有多余的线程来使用了。。。。");
    }
  }

  /**
   * 返回线程池中还有几个线程可用
   * 
   * @return
   */
  public int getPoolSize() {
    return maxPoolSize - usedThreadCount;
  }

  /**
   * 核心线程类
   * 
   * @author Administrator
   *
   */
  private class CoreThread extends Thread {
    private BlockingQueue<Runnable> coreThreadQueue;

    public CoreThread(BlockingQueue<Runnable> coreThreadQueue) {
      super();
      this.coreThreadQueue = coreThreadQueue;
    }

    // 核心线程一直存在
    public void run() {
      while (true) {
        if (coreThreadQueue.size() != 0) {
          usedThreadCount++;
          try {
            Runnable r = coreThreadQueue.take();
            r.run();
            usedThreadCount--;
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
  /**
   * 新建普通线程，执行完任务待一段时间后在消失
   * 
   * @author Administrator
   *
   */
  private class TempThread extends Thread {
    private BlockingQueue<Runnable> coreThreadQueue;

    public TempThread(BlockingQueue<Runnable> coreThreadQueue) {
      super();
      this.coreThreadQueue = coreThreadQueue;
    }

    public void run() {
      while (true) {
        Runnable r;
        try {
          r = coreThreadQueue.take();
          r.run();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        long timeStart = System.currentTimeMillis();
        /**
         * 计算存活时间
         */
        if (System.currentTimeMillis() - timeStart >= aliveTime) {
          usedThreadCount--;
          break;
        }
      }
    }
  }
}
