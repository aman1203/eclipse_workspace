package person.zeng.pcpattern;


/**
 * ����������ģ��
 * @author Administrator
 *
 */
public class PCPattern {
  private static final Repository r = new Repository();
 
  public static void main(String[] args) {
    Producer p = new Producer(r);
    Consumer c = new Consumer(r);
    Thread t1 = new Thread(p);
    Thread t2 = new Thread(c);
    t1.start();t2.start();
  }
}
