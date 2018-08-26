package person.zeng.pattern;

/**
 * �򵥹���ģʽ ����һ����Ʒ�ӿ�,�����Ͽ���-���ԭ�򣬼���չ���ţ��޸ķ�գ�һ�����µĲ�Ʒ����Ҫ�޸�SimpleFactoryPattern��if�߼���
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
