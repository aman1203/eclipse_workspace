package person.zeng.pcpattern;

/**
 * ЩњВњеп
 * 
 * @author Administrator
 *
 */
public class Producer implements Runnable {
  private Repository r;
  
  public Producer(Repository r) {
    super();
    this.r = r;
  }

  @Override
  public void run() {
    while(true) {
     r.produce();
    }
  }
}
