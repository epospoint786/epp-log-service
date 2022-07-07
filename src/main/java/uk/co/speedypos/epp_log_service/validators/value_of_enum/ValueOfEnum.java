package uk.co.speedypos.epp_log_service.validators.value_of_enum;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Custom annotation to validate if the value of a enum field is one of the enum values.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValueOfEnumValidator.class)
public @interface ValueOfEnum {
    Class<? extends Enum<?>> enumClass();
    String message() default "Invalid value for enum type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}