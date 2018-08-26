package com.example.hadoop.config;

import java.lang.reflect.Method;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@org.springframework.context.annotation.Configuration
@EnableCaching
public class Configuration extends CachingConfigurerSupport {

  

  @Bean
  public CacheManager cacheManager() {
    RedisCacheManager redis = new RedisCacheManager(stringRedisTemplate());
    return null;
  }

  @Bean
  public NameMatchMethodPointcut nameMatchMethodPointcut() {
    NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
    nameMatchMethodPointcut.setMappedName("getDate");
    return nameMatchMethodPointcut;
  }

  @Bean
  public KeyGenerator keyGenerator() {
    KeyGenerator keyGenerator = new KeyGenerator() {

      @Override
      public Object generate(Object target, Method method, Object... params) {
        String key = target.getClass().getName() + "." + method.getName();
        return key;
      }
    };
    return keyGenerator;
  }
  @Bean
  public StringRedisTemplate stringRedisTemplate() {
    return new StringRedisTemplate(factory);
  }
  @Autowired
  private RedisConnectionFactory factory; 
}
