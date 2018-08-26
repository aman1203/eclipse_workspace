package person.example.hadoop;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * 主类入口,配置类
 * 
 * @author Administrator
 *
 */
public class WordCountApp {
  private static final String fs_defaultFS = "hdfs://192.168.1.103:9000/";
  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    conf.set("fs.defaultFS", fs_defaultFS);
    Job job = Job.getInstance(conf);
    
    //指定map 和 reduce 的位置，WordCountApp同一个classpath下面
    job.setJarByClass(WordCountApp.class);
    
    //输出数据类型
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(LongWritable.class);
    
    //输出数据类型
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(LongWritable.class);
    
    //job所负责的map和reduce位置
    job.setMapperClass(WordCountMap.class);
    job.setReducerClass(WordCountReduce.class);
    
    //数据源
    FileInputFormat.setInputPaths(job, new Path("/wc/"));
    //结果输出
    FileOutputFormat.setOutputPath(job, new Path("/wc/result/"));
    
    //提交任务
    job.waitForCompletion(true);
  }
}
