package uk.co.speedypos.epp_log_service.models.request.log.internal.mq;

import lombok.Data;
import uk.co.speedypos.epp_log_service.enums.LogType;

import javax.validation.constraints.NotNull;

/**
 * This class is used to handle Validation layer for log internal create http request.
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class LogCreateRequest {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private LogType logType;

    @NotNull
    private String userId;

    @NotNull
    private String platformId;

    @NotNull
    private String moduleId;

}
