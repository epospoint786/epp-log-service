package uk.co.speedypos.epp_log_service.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.speedypos.epp_log_service.dtos.LogEntityDto;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;
import uk.co.speedypos.epp_log_service.repositories.LogEntityRepository;
import uk.co.speedypos.epp_log_service.services.interfaces.LogAccessorService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of {@link LogAccessorService} interface.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class LogAccessorServiceImpl implements LogAccessorService {

    private final LogEntityRepository logEntityRepository;

    @Override
    public List<LogEntityDto> getAllLogs() throws EntityFoundException {

        // todo: will be implemented in the future.
        return null;

    }

    @Override
    public Optional<LogEntityDto> getLog(Long id) throws EntityFoundException {

        // todo: will be implemented in the future.
        return Optional.empty();

    }

    @Override
    public Optional<LogEntityDto> getLog(UUID uuid) throws EntityFoundException {

        // todo: will be implemented in the future.
        return Optional.empty();

    }
}
