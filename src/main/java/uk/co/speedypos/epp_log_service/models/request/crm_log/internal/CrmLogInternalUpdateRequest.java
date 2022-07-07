package uk.co.speedypos.epp_log_service.models.request.crm_log.internal;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import uk.co.speedypos.epp_log_service.entities.CrmLogEntity;
import uk.co.speedypos.epp_log_service.enums.LogType;
import uk.co.speedypos.epp_log_service.validators.id_exist.IdExists;
import uk.co.speedypos.epp_log_service.validators.uuid_exist.UuidExists;
import uk.co.speedypos.epp_log_service.validators.value_of_enum.ValueOfEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Request body for internal update crm log request.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
public class CrmLogInternalUpdateRequest {

    @NotNull(message = "ID is required cannot be null!")
    @Min(value = 100000000, message = "ID must be greater than or equal to 1000000000!")
    @IdExists(message = "ID does not exist in the system and cannot be updated!", entityClass = CrmLogEntity.class)
    private Long id;

    @NotNull(message = "UUID is required cannot be null!")
    @UuidExists(message = "UUID does not exist in the system and cannot be updated!", entityClass = CrmLogEntity.class)
    private UUID uuid;

    @NotNull(message = "Message is required and cannot be null!")
    @Length(min = 10, max = 1080, message = "Message must be between 10 and 1080 characters!")
    private String message;

    @NotNull(message = "Log type is required and cannot be null!")
    @ValueOfEnum(message = "Log type must be one of the following: INFO, WARNING, ERROR, SUCCESS!", enumClass = LogType.class)
    private String logType;

    @NotNull(message = "User ID is required and cannot be null!")
    @Min(value = 100000000, message = "User ID must be greater than or equal to 1000000000!")
    private Long userId;

}
