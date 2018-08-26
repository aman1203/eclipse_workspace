package person.zeng.lunxu;

public class Consumer implements Runnable {

  @Override
  public void run() {
    while (true) {
      synchronized (Flag.lock) {
        if (!Flag.flag) {
          System.out.println(Thread.currentThread().getName());
          Flag.flag = true;
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          Flag.lock.notify();
        }else {
          try {
            Flag.lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
