package uk.co.speedypos.epp_log_service.models.request.internal.crm;

import lombok.Getter;
import lombok.Setter;
import uk.co.speedypos.epp_log_service.enums.LogType;

import java.util.UUID;

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
    private UUID uuid;
    private LogType logType;
    private Long userId;

}
