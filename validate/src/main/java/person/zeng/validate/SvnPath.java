package person.zeng.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {CustomValidator.class})
@Documented
public @interface SvnPath {
  String regex();
  String message() default "";
  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
