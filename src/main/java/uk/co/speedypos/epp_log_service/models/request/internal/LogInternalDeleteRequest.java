package uk.co.speedypos.epp_log_service.models.request.internal;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Request body for internal delete log request.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
public class LogInternalDeleteRequest {

    private Long id;
    private UUID uuid;

}
