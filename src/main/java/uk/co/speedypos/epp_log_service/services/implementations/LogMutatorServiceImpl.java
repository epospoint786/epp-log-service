package uk.co.speedypos.epp_log_service.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.speedypos.epp_log_service.dtos.LogEntityDto;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityDeleteException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityUpdateException;
import uk.co.speedypos.epp_log_service.repositories.LogEntityRepository;
import uk.co.speedypos.epp_log_service.services.interfaces.LogMutatorService;

/**
 * Implementation of {@link LogMutatorService} interface.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class LogMutatorServiceImpl implements LogMutatorService {

    private final LogEntityRepository logEntityRepository;

    @Override
    public LogEntityDto createLog(LogEntityDto logEntityDto) throws EntityCreateException {
        // todo: will be implemented in the future
        return null;
    }

    @Override
    public LogEntityDto updateLog(LogEntityDto logEntityDto) throws EntityUpdateException {
        // todo: will be implemented in the future
        return null;
    }

    @Override
    public LogEntityDto deleteLog(LogEntityDto logEntityDto) throws EntityDeleteException {
        // todo: will be implemented in the future
        return null;
    }
}
