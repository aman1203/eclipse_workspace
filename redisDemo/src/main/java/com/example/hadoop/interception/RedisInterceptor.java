package com.example.hadoop.interception;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;
import com.example.hadoop.constant.RedisLockConstant;
import com.example.hadoop.inteface.DemoService;
@Component
public class RedisInterceptor implements MethodInterceptor{
  @Autowired
  private DemoService service;
  @Autowired
  private KeyGenerator keygenerator;
  @Override
  public Object invoke(MethodInvocation method) throws Throwable {
    String key1 = null; 
    Object object = null;
    Method m = method.getMethod();
    Object obj = m.getDeclaringClass().newInstance();
    String methodName = method.getMethod().getName();
    
    if(methodName.startsWith("get")) {
      if(method.getMethod().isAnnotationPresent(Cacheable.class)) {
        //创建分布式锁
        String  result = service.createLock();
        if("Success".equals(result)) {
          //执行方法，前往数据库查询结果
          String str = (String)method.proceed();
          object = str;
          if("result is null".equals(str)||str!=null) {
            //成功执行数据库查询任务,存入缓存中，删除缓存
            String key = keygenerator.generate(obj, m).toString();
            key1 = key;
            service.set(key, str);
            service.delLock(RedisLockConstant.LIST_LOCK_KEY);
          }
        }
        //分布式锁创建失败，则永远去缓存里面拿数据
        if("Failure".equals(result)) {
          boolean  flag  = true;
          while(flag) {
            String result1 = service.get(key1);
            if(result1!=null) {
              break;
            }
          }
        }
      }
    }
    
    return null;
  }

 

}
