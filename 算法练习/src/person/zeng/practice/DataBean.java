package person.zeng.practice;

import java.util.List;

public class DataBean implements Comparable<DataBean> {
  private char c;
  private List<Integer> index;
  private int count;

  public DataBean(char c, List<Integer> index, int count) {
    super();
    this.c = c;
    this.index = index;
    this.count = count;
  }

  public char getC() {
    return c;
  }

  public void setC(char c) {
    this.c = c;
  }

  public List<Integer> getIndex() {
    return index;
  }

  public void setIndex(List<Integer> index) {
    this.index = index;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  /**
   * 按照count 升序排列
   */
  @Override
  public int compareTo(DataBean o) {
   if(this.c==o.getC()) {
     return 0;
   }
   if(this.c>o.getC()) {
     return 1;
   }
   return -1;
  }
  

  @Override
  public int hashCode() {
    return 1;
  }

  /**
   * 判断两个bean 是否属于同一个
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DataBean) {
      DataBean bean = (DataBean) obj;
      if (this.c == bean.getC()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return c+"["+count+"]";
  }

 
}
