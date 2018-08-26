package person.zeng.validate;

import java.util.ArrayList;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    User user = new User();
    user.setSvnPath("http://1");
    List list = new ArrayList();
    list.add(1);
    user.setAuthList(list);
    ValidateResult result = ValidatorService.validate(user);
    System.out.println(result.getMessage());
  }
}
