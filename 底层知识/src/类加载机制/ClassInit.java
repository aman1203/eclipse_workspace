package ����ػ���;


public class ClassInit {
  public static void main(String[] args) {
    System.out.println("���ྲ̬�����");
    System.out.println("���ྲ̬�����");
    System.out.println("������ͨ�����");
    System.out.println("������ͨ�����");
    System.out.println("���๹�췽��");
    System.out.println("���๹�췽��");
    System.out.println("-------------------------------------------");
    Son son = new Son();
  }
}


class Parent {
  static {
    System.out.println("���ྲ̬�����");
  }

  {
    System.out.println("������ͨ�����");
  }

  public Parent() {
    System.out.println("���๹�췽��");
  }
}


class Son extends Parent {
  static {
    System.out.println("���ྲ̬�����");
  }

  {
    System.out.println("������ͨ�����");
  }

  public Son() {
    System.out.println("���๹�췽��");
  }
}
