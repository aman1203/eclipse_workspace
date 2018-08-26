package person.zeng.pcpattern;

public class Repository {
  private int count;

  public synchronized void produce() {
    if (count < 100) {
      count++;
      System.out.println("�����ߣ�" + Thread.currentThread().getName() + "����һ����Ʒ������Ϊ" + count);
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
      System.out.println("�����ߣ�" + Thread.currentThread().getName() + "����һ����Ʒ,ʣ��" + count);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
