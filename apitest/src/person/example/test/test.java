package person.example.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test {
  public static void main(String[] args) throws Exception {
    int corePoolSize = 3;
    int maximumPoolSize = 16;
    int keepAliveTime = 2;
    BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(1);
    TimeUnit unit = TimeUnit.SECONDS;
    ThreadPoolExecutor pool =
        new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    int count = 20;
    while (count > 0) {
      pool.submit(new Task(count));
      count--;
    }
   pool.shutdown();
  }
}


class Task implements Runnable {
  private int flag;

  public Task(int flag) {
    super();
    this.flag = flag;
  }

  @Override
  public void run() {
    System.out.println(flag);
  }
}
