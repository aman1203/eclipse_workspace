package person.example.hadoop2;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 流量统计的map task
 * 输出key phoneNo
 * 输出value FlowBean
 * @author Administrator
 *
 */
public class FlowMap extends Mapper<LongWritable, Text, Text,FlowBean>{
  private static final Logger log = LoggerFactory.getLogger(FlowMap.class);
  @Override
  protected void map(LongWritable key, Text value,Context context)
      throws IOException, InterruptedException {
    FlowBean flowBean = new FlowBean();
    String content = value.toString();
    String[] values = StringUtils.split(content, "\t");
    flowBean.setPhoneNo(values[0]);
    long u = Long.parseLong(StringUtils.substringAfter(values[1],"=").trim());
    long d = Long.parseLong(StringUtils.substringAfter(values[2],"=").trim());
    flowBean.setU_flow(u);//上行流量
    flowBean.setD_flow(d);//下行流量
    flowBean.setS_flow(u+d);//总流量
    //输出map数据
    context.write(new Text(values[0]), flowBean);
  }
}
