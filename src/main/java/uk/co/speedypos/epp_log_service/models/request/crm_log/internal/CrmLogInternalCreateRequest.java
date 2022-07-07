package uk.co.speedypos.epp_log_service.models.request.crm_log.internal;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import uk.co.speedypos.epp_log_service.enums.LogType;
import uk.co.speedypos.epp_log_service.validators.value_of_enum.ValueOfEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Request body for internal create crm log request.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CrmLogInternalCreateRequest {

    @NotEmpty(message = "Message is required and cannot be empty or null!")
    @Length(max = 1080, message = "Message must be less than or equal to 1080 characters!")
    private String message;

    @NotNull(message = "Log type is required and cannot be null!")
    @ValueOfEnum(message = "Log type must be one of the following: INFO, WARNING, ERROR, SUCCESS!", enumClass = LogType.class)
    private String logType;

    @NotNull(message = "User id is required and cannot be null!")
    @Min(value = 100000000, message = "User id must be greater than or equal to 1000000000!")
    private Long userId;

}
