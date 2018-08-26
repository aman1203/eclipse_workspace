package com.example.demo.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 异常通知类
 * @author Administrator
 *
 */
import com.example.demo.common.BaseResult;
@RestControllerAdvice
public class ExceptionAdvice {
  @ResponseStatus(value=HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value=Exception.class)
  public BaseResult test(Exception e) {
    return new BaseResult(-1,1,null,"出现问题了："+e.getMessage());
  }
}
