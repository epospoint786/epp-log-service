package uk.co.speedypos.epp_log_service.validators.uuid_exist;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uk.co.speedypos.epp_log_service.entities.BaseEntity;
import uk.co.speedypos.epp_log_service.entities.CrmLogEntity;
import uk.co.speedypos.epp_log_service.services.crm_log.accessor.CrmLogAccessorService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;


/**
 * Validator for {@link UuidExists} annotation.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@RequiredArgsConstructor
@Slf4j
public class UuidExistsValidator implements ConstraintValidator<UuidExists, Object> {

    private final CrmLogAccessorService crmLogAccessorService;

    private Class<? extends BaseEntity> entityClass;

    @Override
    public void initialize(UuidExists UUIDExists) {

        this.entityClass = UUIDExists.entityClass();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if (value == null || value.toString().isEmpty()) {
            return true;
        } else {

            UUID uuid;

            try {
                uuid = UUID.fromString(value.toString());
            } catch (Exception e) {
                return true;
            }

            if (entityClass.equals(CrmLogEntity.class)) {
                return crmLogAccessorService.getCrmLogByUuid(uuid).isPresent();
            }

            else {
                throw new IllegalArgumentException("Entity class not supported");
            }
        }

    }

}
