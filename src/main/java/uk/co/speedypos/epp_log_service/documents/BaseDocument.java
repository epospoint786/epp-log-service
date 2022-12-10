package uk.co.speedypos.epp_log_service.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.UUID;

/**
 * This class provides the common fields for all entities.
 *
 * <p>
 *  <strong>Important:</strong> This is shared by all microservices.
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class BaseDocument {

    @Id
    private String id;

    @Field("uuid")
    private UUID uuid;

    @Field("is_trashed")
    private Boolean isTrashed;

    @Field("total_modify_count")
    private Long totalModifyCount;

    @Field("created_timestamp")
    private Instant createdTimestamp;

    @Field("last_modified_timestamp")
    private Instant lastModifiedTimestamp;

    @Field("trashed_timestamp")
    private Instant trashedTimestamp;
}
