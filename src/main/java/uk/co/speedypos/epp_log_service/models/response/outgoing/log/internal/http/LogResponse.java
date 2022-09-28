package uk.co.speedypos.epp_log_service.models.response.outgoing.log.internal.http;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uk.co.speedypos.epp_log_service.enums.LogType;
import uk.co.speedypos.epp_log_service.models.response.outgoing.base.internal.http.BaseResponse;

/**
 * This class is used to provide log internal http response.
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LogResponse extends BaseResponse {

    private String title;
    private String description;
    private LogType logType;
    private String baseUserId;
    private String platformId;
    private String moduleId;

}
