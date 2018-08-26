package person.example.hadoop1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import person.example.hadoop.conf.ConfigurationKey;

public class FlowApp extends Configured implements Tool {

  public int run(String[] args) throws Exception {
    Job job = Job.getInstance();

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(FlowBean.class);

    job.setMapOutputKeyClass(FlowBean.class);
    job.setMapOutputValueClass(FlowBean.class);

    job.setPartitionerClass(FlowParttition.class);

    job.setMapperClass(FlowMap.class);
    job.setReducerClass(FlowReduce.class);

    job.setJarByClass(FlowApp.class);
    
    FileInputFormat.setInputPaths(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    job.setNumReduceTasks(6);

    return job.waitForCompletion(true) ? 0 : 1;
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    conf.set(ConfigurationKey.FS_DEFAULTFS, "hdfs://192.168.1.103:9000/");
    conf.set(ConfigurationKey.MAPREDUCE_TASH_TIMEOUT, "300000");
    int status = ToolRunner.run(conf, new FlowApp(), args);
    System.exit(status);
  }

}
