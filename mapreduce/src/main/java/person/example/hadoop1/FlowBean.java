package person.example.hadoop1;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.WritableComparable;
/**
 * 定义一个流量对象，对象实现序列化和比较器
 * @author Administrator
 *
 */
public class FlowBean implements WritableComparable<FlowBean>{
  private Long u_flow;
  private Long d_flow;
  private Long s_flow;
  private String phoneNo;
  
  public FlowBean() {
    super();
  }
  public FlowBean(Long u_flow, Long d_flow, String phoneNo) {
    super();
    this.u_flow = u_flow;
    this.d_flow = d_flow;
    this.phoneNo = phoneNo;
    this.s_flow = u_flow+d_flow;
  }
  public void write(DataOutput out) throws IOException {
    out.writeLong(u_flow);
    out.writeLong(d_flow);
    out.writeLong(s_flow);
    out.writeUTF(phoneNo);
  }
  public void readFields(DataInput in) throws IOException {
    u_flow = in.readLong();
    d_flow = in.readLong();
    s_flow = in.readLong();
    phoneNo = in.readUTF();
  }
  /**
   * 按照流量总数降序排列
   */
  public int compareTo(FlowBean flowBean) {
    return  (s_flow-flowBean.getS_flow())>0?1:-1; 
  }
  public Long getU_flow() {
    return u_flow;
  }
  public void setU_flow(Long u_flow) {
    this.u_flow = u_flow;
  }
  public Long getS_flow() {
    return u_flow+d_flow;
  }
  public void setS_flow(Long s_flow) {
    this.s_flow = s_flow;
  }
  public String getPhoneNo() {
    return phoneNo;
  }
  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }
  public Long getD_flow() {
    return d_flow;
  }
  public void setD_flow(Long d_flow) {
    this.d_flow = d_flow;
  }
  @Override
  public String toString() {
    return "u_flow=" + u_flow + "\t d_flow=" + d_flow +"\t s_flow="+ s_flow;
  }
  @Override
  public int hashCode() {
    return 1;
  }
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof FlowBean) {
      FlowBean bean = (FlowBean)obj;
      return StringUtils.equals(bean.getPhoneNo(), this.phoneNo);
    }
    return false;
  }
}
