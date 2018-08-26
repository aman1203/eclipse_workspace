package person.example.hadoop2;

import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * 流量统计的reduce task 
 * 输入key 电话号码 
 * 输入value 流量对象 
 * 输出key 流量对象 
 * 输出 value 空对象
 * 
 * @author Administrator
 *
 */
public class FlowReduce extends Reducer<Text, FlowBean, Text, FlowBean> {
  @Override
  protected void reduce(Text key, Iterable<FlowBean> values,Context context)
      throws IOException, InterruptedException {
    String phoneNo = key.toString();
    long u_flow = 0l;
    long d_flow = 0l;
    for(FlowBean value:values) {
      u_flow+=value.getU_flow();
      d_flow+=value.getD_flow();
    }
    FlowBean bean = new FlowBean(u_flow, d_flow, phoneNo);
    context.write(new Text(phoneNo),bean);
  }
}
