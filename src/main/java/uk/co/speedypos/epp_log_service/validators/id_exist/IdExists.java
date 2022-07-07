package uk.co.speedypos.epp_log_service.validators.id_exist;


import uk.co.speedypos.epp_log_service.entities.BaseEntity;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to validate existence of id in database.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Constraint(validatedBy = IdExistsValidator.class)
public @interface IdExists {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};

    Class<? extends BaseEntity> entityClass();
}