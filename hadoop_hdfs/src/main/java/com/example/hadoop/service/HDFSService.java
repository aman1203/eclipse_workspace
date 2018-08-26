package com.example.hadoop.service;

import java.io.IOException;

/**
 * 文件上传和下载
 * 
 * @author Administrator
 *
 */
public interface HDFSService {
  public String fileUpLoad() throws Exception;

  public String fileLoadDown() throws IOException, Exception;

  public void mkdir(String dir) throws Exception;
  
  public void rm(String path) throws Exception;
}
