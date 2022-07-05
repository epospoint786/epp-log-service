package uk.co.speedypos.epp_log_service.services.interfaces.crm;

import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.entities.CrmLogEntity;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Core interface for {@link CrmLogEntity} accessing operations.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
public interface CrmLogAccessorService {

    /**
     * Get all crm logs.
     *
     * @return List of {@link CrmLogEntityDto} objects.
     * @throws EntityFoundException Thrown when any exception occurs during the retrieval list of crm logs.
     * @since 1.0
     */
    List<CrmLogEntityDto> getAllCrmLogs() throws EntityFoundException;

    /**
     * Get a crm log by its id.
     *
     * @param id (Long) This is the id of the crm log that is going to be retrieved.
     * @return The Optional of {@link CrmLogEntityDto} object.
     * @throws EntityFoundException Thrown when any exception occurs during the retrieval of a crm log.
     * @since 1.0
     */
    Optional<CrmLogEntityDto> getCrmLog(Long id) throws EntityFoundException;

    /**
     * Get a crm log by its Uuid.
     * @param uuid (UUID) This is the UUID of the crm log that is going to be retrieved.
     * @return The Optional of {@link CrmLogEntityDto} object.
     * @throws EntityFoundException Thrown when any exception occurs during the retrieval of a crm log.
     */
    Optional<CrmLogEntityDto> getCrmLog(UUID uuid) throws EntityFoundException;

}
