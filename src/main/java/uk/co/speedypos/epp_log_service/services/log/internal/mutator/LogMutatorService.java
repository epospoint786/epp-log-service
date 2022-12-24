package uk.co.speedypos.epp_log_service.services.log.internal.mutator;

import reactor.core.publisher.Mono;
import uk.co.speedypos.epp_log_service.DTOs.LogDTO;
import uk.co.speedypos.epp_log_service.documents.LogDocument;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;

/**
 * Core interface for {@link LogDocument} external mutation operations business logic.
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
public interface LogMutatorService {

    /**
     * Save log.
     *
     * @param logDTO {@link LogDTO} The log dto to be saved.
     * @return Mono of {@link LogDTO} object that has been saved.
     * @throws EntityCreateException if failed to save log.
     * @since 1.0.0
     */
    Mono<LogDTO> saveLog(LogDTO logDTO) throws EntityCreateException;

}
