package uk.co.speedypos.epp_log_service.services.log.internal.mutator;

import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.MappingException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import uk.co.speedypos.epp_log_service.DTOs.LogDTO;
import uk.co.speedypos.epp_log_service.documents.LogDocument;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.helpers.MapperHelper;
import uk.co.speedypos.epp_log_service.repositories.LogMutatorRepository;

import static uk.co.speedypos.epp_log_service.helpers.ExceptionHelper.getReference;

/**
 * Implementation of {@link LogMutatorService}.
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class LogMutatorServiceImpl implements LogMutatorService {

    private final LogMutatorRepository logMutatorRepository;

    @Override
    public Mono<LogDTO> saveLog(LogDTO logDTO) throws EntityCreateException {
        return logMutatorRepository.save(MapperHelper.map(logDTO, LogDocument.class))
                .map(logDocument -> MapperHelper.map(logDocument, LogDTO.class))
                .onErrorMap(throwable -> {
                    // If throwable is instance of MappingException.
                    if (throwable instanceof MappingException) {
                        throw new EntityCreateException("Failed to map LogDTO to LogDocument or LogDocument to LogDTO due to MappingException", getReference(this.getClass(), throwable), throwable);
                    }

                    // If throwable is instance of MongoException.
                    else if (throwable instanceof MongoException) {
                        throw new EntityCreateException("Failed to save log to database due to MongoException", getReference(this.getClass(), throwable), throwable);
                    }

                    // If throwable is other type.
                    else {
                        throw new EntityCreateException("Failed to save log due to unknown exception", getReference(this.getClass(), throwable), throwable);
                    }
                });
    }
}
