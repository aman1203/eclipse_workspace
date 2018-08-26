package person.zeng.pattern;

import java.util.Observable;

/**
 * π€≤Ï’ﬂ
 * @author Administrator
 *
 */
public class ObserverPattern extends Observable{
  public void notifyOthers(String message) {
    this.setChanged();
    this.notifyObservers(message);
  }
}


