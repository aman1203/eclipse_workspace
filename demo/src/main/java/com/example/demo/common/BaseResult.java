package com.example.demo.common;

import java.io.Serializable;

/**
 * 返回的结果类型
 * 
 * @author Administrator
 *
 */
public class BaseResult<T> implements Serializable{
  private static final long serialVersionUID = 1L;
  private Integer status;// 操作状态
  private Integer code;// 操作代码
  private T Data;// 数据
  private String message;// 操作信息
  
  public static BaseResult success() {
    return new BaseResult(1);
  }
  
  public static BaseResult error() {
    return new BaseResult(-1);
  }
  
  public BaseResult() {
    super();
  }

  public BaseResult(Integer status) {
    super();
    this.status = status;
  }

  public BaseResult(Integer status, Integer code, T data, String message) {
    super();
    this.status = status;
    this.code = code;
    Data = data;
    this.message = message;
  }
  
  public BaseResult(Integer status, Integer code, String message) {
    super();
    this.status = status;
    this.code = code;
    this.message = message;
  }


  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }
  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }
  public T getData() {
    return Data;
  }
  public void setData(T data) {
    Data = data;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  
  
}
