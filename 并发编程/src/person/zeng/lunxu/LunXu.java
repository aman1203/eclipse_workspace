package person.zeng.lunxu;

public class LunXu {
  public static void main(String[] args) {
    Produce p = new Produce();
    Consumer c = new Consumer();
    new Thread(p,"生产者").start();
    new Thread(c,"消费者").start();
  }
}
