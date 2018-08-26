package com.example.hadoop.inteface;

/**
 * 定义接口
 * 
 * @author Administrator
 *
 */
public interface DemoService {
  /**
   * 存入数据
   * @param key
   * @return
   */
  public String set(String key,String value);
  /**
   * 获取分布式锁
   * 
   * @return
   * @throws Exception
   */
  public String getLock() throws Exception;

  /**
   * 创建分布式锁
   * 
   * @param key
   * @param value
   * @return
   * @throws Exception
   */
  public String createLock() throws Exception;

  /**
   * 删除分布式锁
   * 
   * @return
   * @throws Exception
   */
  public String delLock(String key) throws Exception;

  /**
   * 创建允许访问数据库的数组
   * 
   * @param key
   * @return
   * @throws Exception
   */
  public String createLockList(String key, String value) throws Exception;

  /**
   * 获取数组锁的长度
   * 
   * @param key
   * @return
   * @throws Exception
   */
  public String getLockListLen(String key) throws Exception;

  /**
   * 删除分布式锁数组一个元素
   * 
   * @return
   * @throws Exception
   */
  public String delOneElement(String key, String value) throws Exception;

  /**
   * 添加一个元素到分布式锁数组中
   * 
   * @param key
   * @param value
   * @return
   * @throws Exception
   */
  public String addOneElement(String key, String value) throws Exception;
  
  public String get(String key) throws Exception;

}
