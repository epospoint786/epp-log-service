package uk.co.speedypos.epp_log_service.services.implementations.crm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;
import uk.co.speedypos.epp_log_service.repositories.CrmLogEntityRepository;
import uk.co.speedypos.epp_log_service.services.interfaces.crm.CrmLogAccessorService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of {@link CrmLogAccessorService} interface.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class CrmLogAccessorServiceImpl implements CrmLogAccessorService {

    private final CrmLogEntityRepository crmLogEntityRepository;

    @Override
    public List<CrmLogEntityDto> getAllCrmLogs() throws EntityFoundException {

        // todo: will be implemented in the future.
        return null;

    }

    @Override
    public Optional<CrmLogEntityDto> getCrmLog(Long id) throws EntityFoundException {

        // todo: will be implemented in the future.
        return Optional.empty();

    }

    @Override
    public Optional<CrmLogEntityDto> getCrmLog(UUID uuid) throws EntityFoundException {

        // todo: will be implemented in the future.
        return Optional.empty();

    }

}
