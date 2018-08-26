package com.example.demo.cache.redis;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.time.Duration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.example.demo.common.AppContext;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
  @Bean
  public CacheManager cacheMananger(RedisConnectionFactory factory) {
    RedisCacheWriter writer = RedisCacheWriter.nonLockingRedisCacheWriter(factory);
    RedisCacheConfiguration redisDefaultCfg = RedisCacheConfiguration.defaultCacheConfig();
    Environment evn = AppContext.getBean(Environment.class);
    String time = evn.getProperty("person.cache.redis.time-to-live");
    long ttl = Long.valueOf(time);
    redisDefaultCfg = redisDefaultCfg.entryTtl(Duration.ofSeconds(ttl));
    RedisCacheManager manager = new RedisCacheManager(writer, redisDefaultCfg);
    return manager;
  }
  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
    serializer.setObjectMapper(objectMapper());
    RedisSerializer<String> keySer = new StringRedisSerializer(Charset.forName("utf-8"));
    template.setKeySerializer(keySer);
    template.setValueSerializer(serializer);
    template.setConnectionFactory(factory);
    template.afterPropertiesSet();
    return template;
  }
  private ObjectMapper objectMapper() {
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL,Visibility.ANY);
    om.enableDefaultTyping(DefaultTyping.NON_FINAL);
    return om;
  }
  @Bean(name="keyGenerator")
  public KeyGenerator keyGenerator() {
    KeyGenerator key = new KeyGenerator() {
      
      @Override
      public Object generate(Object target, Method method, Object... params) {
        StringBuffer sb = new StringBuffer();
        sb.append(target.getClass().getName()+".");
        //sb.append(method.getName()+".");
        for(Object obj:params) {
          if(obj!=null) {
            String str =obj.toString();
            sb.append(str+".");
          }
        }
        if(sb.toString().endsWith(".")) {
          return sb.toString().substring(0,sb.toString().length()-1);
        }
        return sb.toString();
      }
    };
    return key;
  }
}
