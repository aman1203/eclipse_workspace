package person.zeng.validate;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidatorService {
  static int i = 1;
  public static ValidateResult validate(Object obj) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Object>> set = validator.validate(obj);
    StringBuffer sb = new StringBuffer();
    
    set.forEach(c->{
      sb.append("第"+i+"处错误："+c.getMessage()+"\n");
      i++;
    });
    return new ValidateResult(set.size(), sb.toString());
  }
}
