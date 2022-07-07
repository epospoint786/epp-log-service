package uk.co.speedypos.epp_log_service.models.request.crm_log.internal;

import lombok.Getter;
import lombok.Setter;
import uk.co.speedypos.epp_log_service.enums.LogType;

/**
 * Request body for internal delete crm log request.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
public class CrmLogInternalDeleteRequest {

    private Long id;
    private String uuid;
    private LogType logType;
    private Long userId;

}
