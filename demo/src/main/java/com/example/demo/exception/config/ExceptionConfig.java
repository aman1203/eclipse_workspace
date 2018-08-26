package com.example.demo.exception.config;

import java.util.Optional;
import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
/**
 * 异常配置类
 * @author Administrator
 *
 */
import com.example.demo.exception.filter.ExceptionFilter;
@Configuration
public class ExceptionConfig {
  /**
   * 配置异常过滤器
   * @return
   */
  @Bean
  public ExceptionFilter exceptionFilter() {
    return new ExceptionFilter();
  }
  /**
   * 配置拦截器顺序
   */
  @Bean
  public FilterRegistrationBean<Filter> filterRegistrationBean(@Value("${person.exception.ignoreurl}")String urlPattern){
    String[] urlPatterns = Optional.ofNullable(urlPattern).orElse("").split(",");
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<Filter>(exceptionFilter());
    filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    filterRegistrationBean.addUrlPatterns(urlPatterns);
    return filterRegistrationBean;
  }
}
