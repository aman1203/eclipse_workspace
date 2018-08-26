package com.example.feignClient.service;

/**
 * 定义返回结果基础类
 * 
 * @author Administrator
 *
 */
public class BaseResult<T> {
  private Integer status;
  private String code;
  private String message;
  private T data;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
