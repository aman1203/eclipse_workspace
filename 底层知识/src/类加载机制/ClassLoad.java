package ����ػ���;
/**
 * java ������ػ���
 * 1.bootstrapclassLoader %java_home%jre/lib�������
 * 2.extensionClassLoader %java_home%jre/lib/ext �������չ��
 * 3.appClassLoader �û��ڴ��������Զ������
 * 
 * ����ز���˫��ί��ģ�ͽ��е�
 * @author Administrator
 *
 */
public class ClassLoad {
  public static void main(String[] args) throws ClassNotFoundException {
    Class c = Class.forName("����ػ���.TestClass");
    System.out.println("�����ࣺ"+c.getClassLoader().getParent().getClass().getSimpleName());
  }
}
