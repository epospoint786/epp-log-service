package uk.co.speedypos.epp_log_service.controllers.log.internal.mq.mutator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uk.co.speedypos.epp_log_service.DTOs.LogDTO;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.helpers.MapperHelper;
import uk.co.speedypos.epp_log_service.models.request.log.internal.mq.LogCreateRequest;
import uk.co.speedypos.epp_log_service.services.log.internal.mutator.LogMutatorService;

import static uk.co.speedypos.epp_log_service.helpers.ExceptionHelper.getReference;

/**
 * Implementation of {@link LogMutatorController}.
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
@RequiredArgsConstructor
public class LogMutatorControllerImpl implements LogMutatorController {

    private final LogMutatorService logMutatorService;

    @Override
    public void createLog(LogCreateRequest logCreateRequest) throws EntityCreateException {
        logMutatorService.saveLog(MapperHelper.map(logCreateRequest, LogDTO.class))
                .onErrorMap(throwable -> {
                    // if throwable is instanceof EntityCreateException, then return it
                    if (throwable instanceof EntityCreateException) {
                        return throwable;
                    }

                    // if throwable is instanceof MappingException, then throw EntityCreateException.
                    else if (throwable instanceof org.modelmapper.MappingException) {
                        return new EntityCreateException("Failed to map LogCreateRequest to LogDTO or LogDTO to LogResponse due to MappingException!", getReference(this.getClass(), throwable), throwable);
                    }

                    // if throwable is other type of exception, then throw EntityCreateException.
                    else {
                        return new EntityCreateException("Failed to create log due to unknown exception!", getReference(this.getClass(), throwable), throwable);
                    }
                }).subscribe();
    }
}
