package person.zeng.lunxu;
/**
 * ЩњВњеп
 * @author Administrator
 *
 */
public class Produce implements Runnable{

  @Override
  public void run() {
    while(true) {
      synchronized (Flag.lock) {
        if(Flag.flag) {
          System.out.println(Thread.currentThread().getName());
          Flag.flag = false;
          try {
            Thread.sleep(1000);
            Flag.lock.notify();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
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
