package uk.co.speedypos.epp_log_service.models.request.internal.crm;

import lombok.Getter;
import lombok.Setter;
import uk.co.speedypos.epp_log_service.enums.LogType;

/**
 * Request body for internal create crm log request.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
public class CrmLogInternalCreateRequest {

    private String message;
    private LogType logType;
    private Long userId;

}
