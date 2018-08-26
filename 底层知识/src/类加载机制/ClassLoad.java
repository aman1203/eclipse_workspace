package 类加载机制;
/**
 * java 的类加载机制
 * 1.bootstrapclassLoader %java_home%jre/lib下面的类
 * 2.extensionClassLoader %java_home%jre/lib/ext 下面的扩展类
 * 3.appClassLoader 用户在代码里面自定义的类
 * 
 * 类加载采用双亲委托模型进行的
 * @author Administrator
 *
 */
public class ClassLoad {
  public static void main(String[] args) throws ClassNotFoundException {
    Class c = Class.forName("类加载机制.TestClass");
    System.out.println("加载类："+c.getClassLoader().getParent().getClass().getSimpleName());
  }
}
