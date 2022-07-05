package uk.co.speedypos.epp_log_service.services.interfaces;

import uk.co.speedypos.epp_log_service.dtos.LogEntityDto;
import uk.co.speedypos.epp_log_service.entities.LogEntity;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityDeleteException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityUpdateException;

/**
 * Core interface for {@link LogEntity} mutating operations.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
public interface LogMutatorService {

    /**
     * Create a new log.
     *
     * @param logEntityDto ({@link LogEntityDto}) This is the log that is going to be created.
     * @return The created {@link LogEntityDto} object.
     * @throws EntityCreateException Thrown when any exception occurs during the creation of a log.
     * @since 1.0
     */
    LogEntityDto createLog(LogEntity logEntityDto) throws EntityCreateException;

    /**
     * Update an existing log.
     *
     * @param logEntityDto ({@link LogEntityDto}) This is the log that is going to be updated.
     * @return The updated {@link LogEntityDto} object.
     * @throws EntityUpdateException Thrown when any exception occurs during the update of a log.
     * @since 1.0
     */
    LogEntityDto updateLog(LogEntity logEntityDto) throws EntityUpdateException;

    /**
     * Delete an existing log.
     *
     * @param logEntityDto ({@link LogEntityDto}) This is the log that is going to be deleted.
     * @return The deleted {@link LogEntityDto} object.
     * @throws EntityDeleteException Thrown when any exception occurs during the deletion of a log.
     * @since 1.0
     */
    LogEntityDto deleteLog(LogEntity logEntityDto) throws EntityDeleteException;

}
