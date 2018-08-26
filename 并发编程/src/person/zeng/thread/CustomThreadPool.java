package person.zeng.thread;
/**
 * �Զ���һ���̳߳أ�����ThreadPoolExecutors;
 * 
 * @author Administrator
 *
 */

import java.util.concurrent.BlockingQueue;

public class CustomThreadPool {
  private volatile int usedThreadCount = 0;
  private int corePoolSize;
  private int maxPoolSize;
  private long aliveTime;// ͬһʱ��Ϊ����
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
   * 1.���̳߳��ύ�������>��������maxPoolSize>corePool,��������ӵ���������� 2.�����µ��߳���������������е�����
   * 3.�������������ˣ������̳߳��������̶߳��ڹ��������ʱ��������Ļ��Ϳ�ʼ�ܾ�������ӣ�4�оܾ����ԣ�
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
    if (getPoolSize() > maxPoolSize - corePoolSize) {// �����̻߳�û�����꣬�����񽻸������߳�ȥִ��
      usedThreadCount++;
    } else if (getPoolSize() <= maxPoolSize - corePoolSize) {// ��������������ȥ,�½��߳�������
      Thread thread = new TempThread(queue);
      thread.setName("tempThread_" + (usedThreadCount + 1));
      usedThreadCount++;
    } else if (getPoolSize() <= 0) {
      throw new Exception("�Ѿ�û�ж�����߳���ʹ���ˡ�������");
    }
  }

  /**
   * �����̳߳��л��м����߳̿���
   * 
   * @return
   */
  public int getPoolSize() {
    return maxPoolSize - usedThreadCount;
  }

  /**
   * �����߳���
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

    // �����߳�һֱ����
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
   * �½���ͨ�̣߳�ִ���������һ��ʱ�������ʧ
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
         * ������ʱ��
         */
        if (System.currentTimeMillis() - timeStart >= aliveTime) {
          usedThreadCount--;
          break;
        }
      }
    }
  }
}
