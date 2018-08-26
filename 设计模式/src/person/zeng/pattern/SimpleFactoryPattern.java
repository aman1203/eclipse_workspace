package person.zeng.pattern;

/**
 * 简单工厂模式 定义一个产品接口,不符合开放-封闭原则，即扩展开放，修改封闭，一旦有新的产品就需要修改SimpleFactoryPattern的if逻辑了
 * 
 * @author Administrator
 *
 */
public class SimpleFactoryPattern {
  public static Product createProduct(String name) {
    if (name.equals("ProecutA")) {
      return new ProductA();
    } else if (name.equals("ProecuB")) {
      return new ProductB();
    } else {
      return new ProductB();
    }
  }
}
