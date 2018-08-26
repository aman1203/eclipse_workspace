package ÄÚ´æÄ£ÐÍ;

import java.util.ArrayList;
import java.util.List;

public class MemoryTest {
  public static void main(String[] args) throws InterruptedException{
    print(100);
  }
  public static void print(int n) throws InterruptedException {
    List list = new ArrayList<Object>(10000000);
    Thread.sleep(100);
    print(n-1);
  }
}
