package uk.co.speedypos.epp_log_service.services.implementations.crm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityDeleteException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityUpdateException;
import uk.co.speedypos.epp_log_service.repositories.CrmLogEntityRepository;
import uk.co.speedypos.epp_log_service.services.interfaces.crm.CrmLogMutatorService;

/**
 * Implementation of {@link CrmLogMutatorService} interface.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class CrmLogMutatorServiceImpl implements CrmLogMutatorService {

    private final CrmLogEntityRepository crmLogEntityRepository;

    @Override
    public CrmLogEntityDto createCrmLog(CrmLogEntityDto crmLogEntityDto) throws EntityCreateException {

        // Try to create the crm log.
        try {

            // Call save method of CrmLogEntityRepository to create the crm log.
            var crmLogEntity = crmLogEntityRepository.save(crmLogEntityDto.toEntity());

            // Return the created crm log.
            return crmLogEntity.toDto();
        }

        // Catch any Exception.
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CrmLogEntityDto updateCrmLog(CrmLogEntityDto crmLogEntityDto) throws EntityUpdateException {
        // todo: will be implemented in the future
        return null;
    }

    @Override
    public CrmLogEntityDto deleteCrmLog(CrmLogEntityDto crmLogEntityDto) throws EntityDeleteException {
        // todo: will be implemented in the future
        return null;
    }
}
