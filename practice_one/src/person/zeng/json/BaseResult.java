package person.zeng.json;

public class BaseResult<T>{
  private Integer status;
  private String code;
  private String message;
  private T date;
  
  public BaseResult() {
    super();
  }
  
  public BaseResult(Integer status, String code, String message, T date) {
    super();
    this.status = status;
    this.code = code;
    this.message = message;
    this.date = date;
  }
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
  public T getDate() {
    return date;
  }
  public void setDate(T date) {
    this.date = date;
  }
  
}
