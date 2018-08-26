package com.example.hadoop.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.hadoop.common.Tool;
import com.example.hadoop.service.HDFSService;

/**
 * HDF操作
 * 
 * @author Administrator
 *
 */
@Service
public class HDFSServiceImpl implements HDFSService {

  @Override
  public String fileUpLoad() throws IOException, Exception {
    FileSystem fs = Tool.getFS();
    Path path = new Path("hdfs://192.168.1.103:9000/test/hadoop.txt");
    FSDataOutputStream output = fs.create(path);
    FileInputStream input = new FileInputStream("C:\\Users\\Administrator\\Desktop\\hadoop\\text.txt");
    org.apache.commons.io.IOUtils.copy(input, output);
    return "Success";
  }

  @Override
  public String fileLoadDown() throws IOException, Exception{
    FileSystem fs = Tool.getFS();
    Path path = new Path(new URI("hdfs://192.168.1.103:9000/jdk-8u172-linux-i586.tar.gz"));
    FSDataInputStream input = fs.open(path);
    FileOutputStream output = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\java.tar.gz");
    org.apache.commons.io.IOUtils.copy(input, output);
    return "Success";
  }

  @Override
  public void mkdir(String dir) throws Exception {
    FileSystem fs = Tool.getFS();
    fs.mkdirs(new Path("/"+dir));
  }

  @Override
  public void rm(String path) throws Exception {
    FileSystem fs = Tool.getFS();
    Boolean result = fs.delete(new Path(path), true);
  }
}
