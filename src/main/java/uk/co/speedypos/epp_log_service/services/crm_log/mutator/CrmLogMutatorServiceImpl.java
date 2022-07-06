package uk.co.speedypos.epp_log_service.services.crm_log.mutator;

import lombok.RequiredArgsConstructor;
import org.modelmapper.MappingException;
import org.springframework.stereotype.Service;
import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.entities.CrmLogEntity;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityDeleteException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityUpdateException;
import uk.co.speedypos.epp_log_service.helpers.MapperHelper;
import uk.co.speedypos.epp_log_service.repositories.CrmLogEntityRepository;

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

            // Map crmLogEntityDto to CrmLogEntity.
            var mappedCrmLogEntity = MapperHelper.map(crmLogEntityDto, CrmLogEntity.class);

            // Call save() method of CrmLogEntityRepository to create the crm log.
            var createdCrmLogEntity = crmLogEntityRepository.save(mappedCrmLogEntity);

            // Map createdCrmLogEntity to CrmLogEntityDto and return it.
            return MapperHelper.map(createdCrmLogEntity, CrmLogEntityDto.class);
        }

        // Catch MappingException and throw EntityCreateException.
        catch (MappingException exception) {
            throw  new EntityCreateException("createCrmLog() method of the CrmLogMutatorServiceImpl class", "MappingException occurred during mapping of CrmLogEntityDto to CrmLogEntity", exception.getMessage());
        }


        // Catch all other exceptions and throw EntityCreateException.
        catch (Exception exception) {
            throw  new EntityCreateException("createCrmLog() method of the CrmLogMutatorServiceImpl class", "Exception occurred during creation of crm log entity", exception.getMessage());
        }

    }

    @Override
    public CrmLogEntityDto updateCrmLog(CrmLogEntityDto crmLogEntityDto) throws EntityUpdateException {

        // Try to update the crm log.
        try {

            // Call findByIdAndUuid() method of CrmLogEntityRepository to find the crm log.
            var foundCrmLogEntity = crmLogEntityRepository.findByIdAndUuid(crmLogEntityDto.getId(), crmLogEntityDto.getUuid());

            foundCrmLogEntity.setMessage(crmLogEntityDto.getMessage());
            foundCrmLogEntity.setLogType(crmLogEntityDto.getLogType());
            foundCrmLogEntity.setUserId(crmLogEntityDto.getUserId());

            foundCrmLogEntity.setIsTrashed(crmLogEntityDto.getIsTrashed());

            // Call save() method of CrmLogEntityRepository to update the crm log.
            var updatedCrmLogEntity = crmLogEntityRepository.save(foundCrmLogEntity);

            // Map updatedCrmLogEntity to CrmLogEntityDto and return it.
            return MapperHelper.map(updatedCrmLogEntity, CrmLogEntityDto.class);

        }

        // Catch MappingException and throw EntityUpdateException.
        catch (MappingException exception) {
            throw  new EntityUpdateException("updateCrmLog() method of the CrmLogMutatorServiceImpl class", "MappingException occurred during mapping of CrmLogEntity to CrmLogEntityDto", exception.getMessage());
        }

        // Catch all other exceptions and throw EntityUpdateException.
        catch (Exception exception) {
            throw  new EntityUpdateException("updateCrmLog() method of the CrmLogMutatorServiceImpl class", "Exception occurred during updating of crm log entity", exception.getMessage());
        }


    }

    @Override
    public CrmLogEntityDto deleteCrmLog(CrmLogEntityDto crmLogEntityDto) throws EntityDeleteException {

        // Try to delete the crm log.
        try {

            // Call findByIdAndUuid() method of CrmLogEntityRepository to find the crm log.
            var foundCrmLogEntity = crmLogEntityRepository.findByIdAndUuid(crmLogEntityDto.getId(), crmLogEntityDto.getUuid());

            // Call delete() method of CrmLogEntityRepository to delete the crm log.
            crmLogEntityRepository.delete(foundCrmLogEntity);

            // Map foundCrmLogEntity to CrmLogEntityDto and return it.
            return MapperHelper.map(foundCrmLogEntity, CrmLogEntityDto.class);

        }

        // Catch MappingException and throw EntityDeleteException.
        catch (MappingException exception) {
            throw  new EntityDeleteException("deleteCrmLog() method of the CrmLogMutatorServiceImpl class", "MappingException occurred during mapping of CrmLogEntity to CrmLogEntityDto", exception.getMessage());
        }

        // Catch all other exceptions and throw EntityDeleteException.
        catch (Exception exception) {
            throw  new EntityDeleteException("deleteCrmLog() method of the CrmLogMutatorServiceImpl class", "Exception occurred during deleting of crm log entity", exception.getMessage());
        }

    }
}
