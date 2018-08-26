package com.example.demo.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
@Component
public class AppContext implements ApplicationContextAware{
  private static ApplicationContext applicationContext;
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    if(this.applicationContext==null) {
      this.applicationContext = applicationContext;
    }
  }
  public static Object getBean(String name) {
    return applicationContext.getBean(name);
  }
  public static <T> T getBean(Class<T> requiredType) {
    return applicationContext.getBean(requiredType);
  }
}
