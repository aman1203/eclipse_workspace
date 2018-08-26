package com.example.demo.cache.caffeine;

import java.lang.reflect.Method;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
//@Configuration
//@Primary
public class CaffeineConfig extends CachingConfigurerSupport{
  @Bean
  public CacheManager caffeineCacheManager() {
    CaffeineCacheManager manager = new CaffeineCacheManager();
    CaffeineSpec caffeineSpec = CaffeineSpec.parse("initialCapacity=50,maximumSize=1000,expireAfterAccess=10s");
    CacheLoader<Object, Object> cacheLoader = (item)->{return item;};
    manager.setCaffeineSpec(caffeineSpec);
    manager.setCacheLoader(cacheLoader);
    return manager;
  }
  @Bean
  public org.springframework.cache.interceptor.KeyGenerator keyGenerator() {
    return new CostomKeyGenerator();
  }
  private class CostomKeyGenerator extends SimpleKeyGenerator{
    @Override
    public Object generate(Object target, Method method, Object... params) {
      return super.generate(target, method, params);
    }
  }
}
