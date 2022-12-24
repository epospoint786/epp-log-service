package uk.co.speedypos.epp_log_service.models.response.outgoing.base.internal.http;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * This class used to provide base response for external http request.
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public abstract class BaseResponse implements Serializable {

    private String id;
    private UUID uuid;
    private Boolean isTrashed;
    private Long totalModifyCount;
    private Instant createdTimestamp;
    private Instant lastModifiedTimestamp;
    private Instant trashedTimestamp;

}
