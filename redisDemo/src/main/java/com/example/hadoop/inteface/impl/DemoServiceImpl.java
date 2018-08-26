package com.example.hadoop.inteface.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.example.hadoop.constant.RedisLockConstant;
import com.example.hadoop.domain.Message;
import com.example.hadoop.inteface.DemoService;
import com.example.hadoop.respository.RedisRespository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 接口的实现类
 * 
 * @author Administrator
 *
 */
@Service
public class DemoServiceImpl implements DemoService {
  @Autowired
  private StringRedisTemplate template;

  @Autowired
  private RedisRespository respository;
  
  @Override
  public String getLock() throws Exception {
    return "Success";
  }

  @Override
  public String createLock() throws Exception {
    Boolean result = template.opsForValue().setIfAbsent(RedisLockConstant.SINGLE_LOCK_KEY,
        RedisLockConstant.LOCK_VALUE);
    return result ? "Success" : "Failure";
  }

  @Override
  public String delLock(String key) throws Exception {
    template.setEnableTransactionSupport(true);
    template.multi();
    String lockValue = template.opsForValue().get(RedisLockConstant.SINGLE_LOCK_KEY);
    if (lockValue == null || "".equals(lockValue)) {
      return "Success";
    }
    template.delete(RedisLockConstant.SINGLE_LOCK_KEY);
    template.exec();
    return "Success";
  }

  @Override
  public String createLockList(String key, String value) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getLockListLen(String key) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String delOneElement(String key, String value) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String addOneElement(String key, String value) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 数据库查询数据
   * 
   * @param start
   * @param end
   * @return
   */
  @Cacheable(cacheNames = "cache1")
  public String getData(int start, int end) throws Exception{
    Message message = respository.getOne(new Long(start));
    ObjectMapper om = new ObjectMapper();
    if(message!=null) {
      return om.writeValueAsString(message);
    }
   return "Result is null";
  }

  @Override
  public String set(String key,String value) {
    template.opsForValue().set(key, value);
    return "Success";
  }

  @Override
  public String get(String key) throws Exception {
    String result = template.opsForValue().get(key);
    return result;
  }
}
