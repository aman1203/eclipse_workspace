package com.example.hadoop.common;
/**
 * 工具类
 * @author Administrator
 *
 */

import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

public class Tool {
 public static FileSystem getFS() throws Exception {
   return FileSystem.get(new URI("hdfs://192.168.1.103:9000"), getConf(), "zengjie");
 }
 public static Configuration getConf() {
   Configuration conf = new Configuration();
   conf.set("fs.defaultFS", "hdfs://192.168.1.103:9000");
   conf.set("dfs.replication", "1");
   return conf;
 }
}
