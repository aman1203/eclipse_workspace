package person.zeng.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * ����������"aaabbbbcccc"�г��ִ�����ಢ���ǰ���ַ�
 * 
 * @author Administrator
 *
 */
public class MaxCountChar {
  public static void main(String[] args) {
    String str = "ccccffaaaabbse�������������ҵ�";
    char[] charArray = str.toCharArray();
    Set<DataBean> set = new TreeSet<DataBean>(); 
    for (int i = 0; i < charArray.length; i++) {
      List<Integer> tempList = new ArrayList<>();
      tempList.add(i);
      DataBean db = new DataBean(charArray[i], tempList, 1);
      if (!set.add(db)) {
        for(DataBean b:set) {
          if(b.equals(db)) {
            b.setCount(b.getCount()+1);
            List<Integer> temp = b.getIndex();
            temp.add(i);
            b.setIndex(temp);
          }
        }
      }
    }
    List listSet = new ArrayList<>(set);
    Collections.sort(listSet, new DataBeanCom());
    System.out.println(listSet);
  }
}
