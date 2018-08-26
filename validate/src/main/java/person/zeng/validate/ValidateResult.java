package person.zeng.validate;

public class ValidateResult {
  private Integer size;
  private String message;

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ValidateResult(Integer size, String message) {
    super();
    this.size = size;
    this.message = message;
  }

}
