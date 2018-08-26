package person.zeng.aotmic;

import java.util.concurrent.CopyOnWriteArrayList;

public class AtomicTest {
  public static void main(String[] args) {
    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
    Runnable r1 = () -> {
      int a = 1;
      while (true) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(list.add(a + ""));
        a++;
      }
    };
    Runnable r3 = () -> {
      int a = 1;
      while (true) {
        try {
          Thread.sleep(1000);
          System.out.println(list.remove(a));
        } catch (Exception e) {
          try {
            Thread.sleep(3000);
          } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
          e.printStackTrace();
        }
        a++;
      }
    };
    Runnable r2 = () -> {
      int a = 1;
      while (true) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(list.size());
        a++;
      }
    };
    new Thread(r1).start();
    new Thread(r2).start();
    new Thread(r3).start();
  }
}
