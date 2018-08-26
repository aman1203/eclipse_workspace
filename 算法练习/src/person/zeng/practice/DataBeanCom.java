package person.zeng.practice;

import java.security.GeneralSecurityException;
import java.util.Comparator;
/**
 * 自定义比较器
 * @author Administrator
 *
 */
public class DataBeanCom implements Comparator<DataBean>{

  @Override
  public int compare(DataBean o1, DataBean o2) {
    if(o1.getCount()>o2.getCount()) {
      return -1;
    }
    if(o1.getCount()==o2.getCount()) {
      if(o1.getIndex().get(0)>o2.getIndex().get(0)) {
        return 1;
      }else {
        return -1;
      }
    }
    return 1;
  }
}
