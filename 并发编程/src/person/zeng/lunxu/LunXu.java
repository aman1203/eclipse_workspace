package person.zeng.lunxu;

public class LunXu {
  public static void main(String[] args) {
    Produce p = new Produce();
    Consumer c = new Consumer();
    new Thread(p,"������").start();
    new Thread(c,"������").start();
  }
}
