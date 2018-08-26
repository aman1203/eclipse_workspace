package person.example.hadoop;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * 定义任务执行的mapper，输入key是文件的行号偏移量，输入value是文件的当前行的内容，输出key是单词，输出value是单词次数
 * 
 * @author Administrator
 *
 */
public class WordCountMap extends Mapper<LongWritable, Text, Text, LongWritable> {
  /**
   * 重写map方法
   */
  @Override
  protected void map(LongWritable key, Text value,
      Mapper<LongWritable, Text, Text, LongWritable>.Context context)
      throws IOException, InterruptedException {
    String content = value.toString();
    String[] words = StringUtils.split(content, " ");
    for(String word:words) {
      context.write(new Text(word), new LongWritable(1l));
    }
  }
}
