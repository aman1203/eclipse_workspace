package person.zeng.pattern;
/**
 * ������ƷB�ķ�����������������Ʒ��������ù�������Ĳ�Ʒ���ǽӿ�Product�����Ĳ�Ʒ����ô��ô������
 * ���ʱ���Ҫ����Factory�������µķ�����
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
