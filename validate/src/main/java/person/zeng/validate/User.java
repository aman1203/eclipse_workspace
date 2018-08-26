package person.zeng.validate;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
  @NotNull(message="name 不能为null")
  private String name;
  private Integer age;
  @NotEmpty(message="list 不能为null")
  private List authList;
  @NotEmpty(message="邮箱不能为null")
  private String email;
  @SvnPath(regex="http://*",message="svn格式错了")
  private String svnPath;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public List getAuthList() {
    return authList;
  }

  public void setAuthList(List authList) {
    this.authList = authList;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSvnPath() {
    return svnPath;
  }

  public void setSvnPath(String svnPath) {
    this.svnPath = svnPath;
  }

}
