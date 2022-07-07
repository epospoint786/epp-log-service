package uk.co.speedypos.epp_log_service.validators.id_exist;


import lombok.RequiredArgsConstructor;
import uk.co.speedypos.epp_log_service.entities.BaseEntity;
import uk.co.speedypos.epp_log_service.entities.CrmLogEntity;
import uk.co.speedypos.epp_log_service.services.crm_log.accessor.CrmLogAccessorService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * Validator for {@link IdExists} annotation.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@RequiredArgsConstructor
public class IdExistsValidator implements ConstraintValidator<IdExists, Object> {

    private final CrmLogAccessorService crmLogAccessorService;

    private Class<? extends BaseEntity> entityClass;

    @Override
    public void initialize(IdExists IdExists) {

        this.entityClass = IdExists.entityClass();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if (value != null && !value.toString().isEmpty() && (value instanceof Long id) && (Long) value > 1000000000L) {

            if (entityClass.equals(CrmLogEntity.class)) {
                return crmLogAccessorService.getCrmLogById(id).isPresent();
            } else {
                throw new IllegalArgumentException("Entity class not supported");
            }

        } else {
            return true;
        }

    }

}
