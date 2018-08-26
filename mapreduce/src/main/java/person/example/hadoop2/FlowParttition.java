package person.example.hadoop2;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;
/**
 * map 处理过的数据先经过parttion ,parttion结果决定有哪一个reduce来处理
 * @author Administrator
 *
 */
public class FlowParttition extends Partitioner<Text, FlowBean>{

  @Override
  public int getPartition(Text key, FlowBean value, int numPartitions) {
    String str = StringUtils.substring(key.toString(), 0, 3);
    return PhoneNoDict.region(str);
  }
  
}
