package person.zeng.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * 自定义校验类
 * @author Administrator
 *
 */
public class CustomValidator implements ConstraintValidator<SvnPath, String>{
private String regex;
  @Override
  public void initialize(SvnPath str) {
    this.regex = str.regex();
  }

  @Override
  public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
    if(arg0==null) {
      return false;
    }
    if(arg0.matches(regex)) {
      return true;
    }
    return false;
  }
}
