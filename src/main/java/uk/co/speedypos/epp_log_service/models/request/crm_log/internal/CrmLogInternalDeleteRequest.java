package uk.co.speedypos.epp_log_service.models.request.crm_log.internal;

import lombok.Getter;
import lombok.Setter;
import uk.co.speedypos.epp_log_service.entities.CrmLogEntity;
import uk.co.speedypos.epp_log_service.validators.id_exist.IdExists;
import uk.co.speedypos.epp_log_service.validators.uuid_exist.UuidExists;

import javax.validation.constraints.NotNull;
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

    @NotNull(message = "ID is required and cannot be null!")
    @IdExists(message = "ID does not exist in the system and cannot be deleted!", entityClass = CrmLogEntity.class)
    private Long id;

    @NotNull(message = "UUID is required and cannot be null!")
    @UuidExists(message = "UUID does not exist in the system and cannot be deleted!", entityClass = CrmLogEntity.class)
    private UUID uuid;

}
