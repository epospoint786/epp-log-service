package uk.co.speedypos.epp_log_service.DTOs;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

/**
 * Parent class for all DTOs.
 *
 * <p>
 *  <strong>Important:</strong> This is shared by all microservices
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public abstract class BaseDTO {

    private String id;
    private UUID uuid;
    private Boolean isTrashed;
    private Long totalModifyCount;
    private Instant createdTimestamp;
    private Instant lastModifiedTimestamp;
    private Instant trashedTimestamp;

}
