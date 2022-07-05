package uk.co.speedypos.epp_log_service.models.response.internal;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static uk.co.speedypos.epp_log_service.consts.Regex.LOCAL_DATE_TIME_RESPONSE_PATTERN;

/**
 * Base response model for all UI models.
 *
 * <p>
 * <b>Important:</b> This is shared by all microservices.<br/><br/>
 *
 * <b>Exclude some fields:</b>
 *     <ul>
 *         <li>lastModifiedDate</li>
 *         <li>totalModified</li>
 *         <li>isTrashed</li>
 *         <li>trashedDate</li>
 *     </ul>
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

}
