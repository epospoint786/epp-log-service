package uk.co.speedypos.epp_log_service.models.response.crm_log.internal;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import uk.co.speedypos.epp_log_service.enums.LogType;

/**
 *
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CrmLogInternalResponse extends BaseInternalResponse {

    private String message;
    private LogType logType;
    private Long userId;

}
