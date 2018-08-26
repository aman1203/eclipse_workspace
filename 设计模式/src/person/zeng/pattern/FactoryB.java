package person.zeng.pattern;
/**
 * 生产产品B的方法，现在是生产产品，如果想让工厂做别的产品，非接口Product声明的产品，那么怎么处理呢
 * 这个时候就要抽象Factory，增加新的方法。
 * @author Administrator
 *
 */
public class FactoryB implements Factory{

  @Override
  public Product createProduct() {
    // TODO Auto-generated method stub
    return new ProductB();
  }

}
