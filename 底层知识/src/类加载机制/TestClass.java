package 类加载机制;

public class TestClass {
  private String str = "zengjie";
  public void method1() {
    System.out.println(this.getClass().getDeclaredMethods()[0].getName());
  }
}
