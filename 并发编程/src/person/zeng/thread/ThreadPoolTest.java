package person.zeng.thread;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolTest {
public static void main(String[] args) throws Exception {
  LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
  CustomThreadPool pool = new CustomThreadPool(1, 1, 1000, queue);
  for(int i=0;i<=10;i++) {
    pool.submit(new Task());
  }
}
}

class Task implements Runnable{

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}