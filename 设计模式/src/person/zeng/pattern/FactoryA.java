package person.zeng.pattern;
/**
 * 
 * @author Administrator
 *����A�Ĺ������Կ�����������Ʒ�������ӳٵ������н�����
 */
public class FactoryA implements Factory{

  @Override
  public Product createProduct() {
    // TODO Auto-generated method stub
    return new ProductA();
  }

}
