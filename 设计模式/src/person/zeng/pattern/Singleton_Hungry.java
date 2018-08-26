package person.zeng.pattern;
/**
 * ������
 * @author Administrator
 *
 */
public class Singleton_Hungry {
  private static final Singleton_Hungry singleton = new Singleton_Hungry();
  private Singleton_Hungry() {
    
  }
  public static Singleton_Hungry getSingleInstance() {
    return singleton;
  }
}
