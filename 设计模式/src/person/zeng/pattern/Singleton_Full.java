package person.zeng.pattern;
/**
 * ±¥ººÐÍ
 * @author Administrator
 *
 */
public class Singleton_Full {
  private static Singleton_Full singleton;
  private Singleton_Full() {};
  public static Singleton_Full getSingleInstance() {
    if(singleton!=null) {
      return singleton; 
    }else {
      synchronized (Singleton_Full.class) {
        if(singleton!=null) {
          return singleton;
        }else {
          singleton = new Singleton_Full();
        }
        return singleton;
      }
    }
  }
}
