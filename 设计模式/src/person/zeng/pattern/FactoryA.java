package person.zeng.pattern;
/**
 * 
 * @author Administrator
 *生产A的工厂可以看出来，将产品的生产延迟到子类中进行了
 */
public class FactoryA implements Factory{

  @Override
  public Product createProduct() {
    // TODO Auto-generated method stub
    return new ProductA();
  }

}
