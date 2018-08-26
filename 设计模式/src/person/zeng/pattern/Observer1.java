package person.zeng.pattern;

import java.util.Observable;
import java.util.Observer;

public class Observer1 implements Observer{

  @Override
  public void update(Observable o, Object arg) {
    System.out.println(o.getClass().getName()+"֪ͨ: "+arg);
  }
}
