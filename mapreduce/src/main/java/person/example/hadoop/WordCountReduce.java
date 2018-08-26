package person.example.hadoop;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
/**
 * 聚合任务，输入key是单词，输入value是单词次数，输出key是单词，输出value是单词总的次数
 * @author Administrator
 *
 */
public class WordCountReduce extends Reducer<Text, LongWritable, Text, LongWritable>{
  /**
   * 重写聚合运算，统计单词次数
   */
  @Override
  protected void reduce(Text word, Iterable<LongWritable> words,
      Reducer<Text, LongWritable, Text, LongWritable>.Context context)
      throws IOException, InterruptedException {
    long count = 0L;
    Iterator<LongWritable> it = words.iterator();
    while(it.hasNext()) {
      it.next();
      count++;
    }
    context.write(word, new LongWritable(count));
  }
}
