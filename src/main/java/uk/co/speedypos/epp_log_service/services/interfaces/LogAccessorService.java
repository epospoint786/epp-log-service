package uk.co.speedypos.epp_log_service.services.interfaces;

import uk.co.speedypos.epp_log_service.dtos.LogEntityDto;
import uk.co.speedypos.epp_log_service.entities.LogEntity;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Core interface for {@link LogEntity} accessing operations.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
public interface LogAccessorService {

    /**
     * Get all logs.
     *
     * @return List of {@link LogEntityDto} objects.
     * @throws EntityFoundException Thrown when any exception occurs during the retrieval list of logs.
     * @since 1.0
     */
    List<LogEntityDto> getAllLogs() throws EntityFoundException;

    /**
     * Get a log by its id.
     *
     * @param id (Long) This is the id of the log that is going to be retrieved.
     * @return The Optional of {@link LogEntityDto} object.
     * @throws EntityFoundException Thrown when any exception occurs during the retrieval of a log.
     * @since 1.0
     */
    Optional<LogEntityDto> getLog(Long id) throws EntityFoundException;

    /**
     * Get a log by its Uuid.
     * @param uuid (UUID) This is the UUID of the log that is going to be retrieved.
     * @return The Optional of {@link LogEntityDto} object.
     * @throws EntityFoundException Thrown when any exception occurs during the retrieval of a log.
     */
    Optional<LogEntityDto> getLog(UUID uuid) throws EntityFoundException;

}
