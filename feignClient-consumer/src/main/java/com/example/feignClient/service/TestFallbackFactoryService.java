package com.example.feignClient.service;

import java.io.IOException;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.hystrix.FallbackFactory;
/**
 * feignClient调用时异常处理
 * @author Administrator
 *
 */
@Component
public class TestFallbackFactoryService implements FallbackFactory<TestService>{

  @Override
  public TestService create(Throwable exception) {
    return new TestService() {
      private String exceptionResult() throws IOException {
        String message = exception.getMessage();
        BaseResult<String> result = new BaseResult<>();
        result.setStatus(-1);
        result.setCode("10001");
        result.setMessage("操作失败");
        result.setData(message);
        return new ObjectMapper().writeValueAsString(result);
      }
      @Override
      public String test() {
        String message = "";
        try {
          message = exceptionResult();
          return message;
        } catch (IOException e) {
          return message;
        }
      }

      @Override
      public String test1() {
        String message = "";
        try {
          message = exceptionResult();
          return message;
        } catch (IOException e) {
          return message;
        }
      }
      
    };
  }

}
