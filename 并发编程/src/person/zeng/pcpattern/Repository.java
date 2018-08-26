package person.zeng.pcpattern;

public class Repository {
  private int count;

  public synchronized void produce() {
    if (count < 100) {
      count++;
      System.out.println("生产者：" + Thread.currentThread().getName() + "生产一件商品，总数为" + count);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }
  }

  public synchronized void consum() {
    if (count > 0) {
      count--;
      System.out.println("消费者：" + Thread.currentThread().getName() + "消费一件商品,剩下" + count);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
