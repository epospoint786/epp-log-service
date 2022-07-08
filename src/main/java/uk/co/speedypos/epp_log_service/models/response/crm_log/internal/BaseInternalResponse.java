package uk.co.speedypos.epp_log_service.models.response.crm_log.internal;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static uk.co.speedypos.epp_log_service.consts.DateTimeRegex.LOCAL_DATE_TIME_RESPONSE_PATTERN;

/**
 * Base response model for all UI models.
 *
 * <p>
 *  <strong>Important:</strong> This is shared by all microservices
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
public abstract class BaseInternalResponse implements Serializable {

    private Long id;

    private UUID uuid;

    @JsonFormat(pattern = LOCAL_DATE_TIME_RESPONSE_PATTERN)
    private LocalDateTime createdDate;

    @JsonFormat(pattern = LOCAL_DATE_TIME_RESPONSE_PATTERN)
    private LocalDateTime lastModifiedDate;

    @JsonFormat(pattern = LOCAL_DATE_TIME_RESPONSE_PATTERN)
    private Long totalModified;

    private Boolean isTrashed;

    @JsonFormat(pattern = LOCAL_DATE_TIME_RESPONSE_PATTERN)
    private LocalDateTime trashedDate;

}
