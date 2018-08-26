package person.zeng.pcpattern;

public class Consumer implements Runnable{
 private Repository r;

  public Consumer(Repository r) {
  super();
  this.r = r;
}


  @Override
  public void run() {
    while(true) {
      r.consum();
    }
  }
}
