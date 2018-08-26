package com.example.hadoop.constant;

/**
 * 分布式锁的配置参数
 * 
 * @author Administrator
 *
 */
public class RedisLockConstant {
  /**
   * 单锁的key值
   */
  public static final String SINGLE_LOCK_KEY = "single_lock_key";
  /**
   * 多锁list的key值
   */
  public static final String LIST_LOCK_KEY = "list_lock_key";
  /***
   * 锁中存放的value的值
   */
  public static final String LOCK_VALUE = "1";
  
}
