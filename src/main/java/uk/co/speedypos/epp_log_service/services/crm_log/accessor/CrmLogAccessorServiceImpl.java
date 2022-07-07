package uk.co.speedypos.epp_log_service.services.crm_log.accessor;

import lombok.RequiredArgsConstructor;
import org.modelmapper.MappingException;
import org.springframework.stereotype.Service;
import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;
import uk.co.speedypos.epp_log_service.helpers.MapperHelper;
import uk.co.speedypos.epp_log_service.repositories.CrmLogEntityRepository;

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
    public List<CrmLogEntityDto> getCrmLogs() throws EntityFoundException {

        // Try to get all crm logs.
        try {

            // Call findAll() method of CrmLogEntityRepository to get all crm logs.
            var foundedCrmLogEntityList = crmLogEntityRepository.findAll();

            // Map the founded list of CrmLogEntity to a list of CrmLogEntityDto and return it.
            return MapperHelper.mapList(foundedCrmLogEntityList, CrmLogEntityDto.class);

        }

        // Catch MappingException and throw EntityFoundException.
        catch (MappingException mappingException) {
            throw new EntityFoundException("getCrmLogs() method of the CrmLogAccessorServiceImpl class", "MappingException thrown while mapping the list of CrmLogEntity to a list of CrmLogEntityDto", mappingException.getMessage());
        }

        // Catch Exception and throw EntityFoundException.
        catch (Exception exception) {
            throw new EntityFoundException("getCrmLogs() method of the CrmLogAccessorServiceImpl class", "Exception thrown while retrieving the list of CrmLogEntity", exception.getMessage());
        }

    }

    @Override
    public List<CrmLogEntityDto> getCrmLogsByUserId(Long userId) throws EntityFoundException {

        // Try to get all crm logs by user id.
        try {

            // Call findAllByUserId() method of CrmLogEntityRepository to get all crm logs by user id.
            var foundedCrmLogEntityList = crmLogEntityRepository.findAllByUserId(userId);

            // Map the founded list of CrmLogEntity to a list of CrmLogEntityDto and return it.
            return MapperHelper.mapList(foundedCrmLogEntityList, CrmLogEntityDto.class);

        }

        // Catch MappingException and throw EntityFoundException.
        catch (MappingException mappingException) {
            throw new EntityFoundException("getCrmLogsByUserId() method of the CrmLogAccessorServiceImpl class", "MappingException thrown while mapping the list of CrmLogEntity to a list of CrmLogEntityDto", mappingException.getMessage());
        }

        // Catch Exception and throw EntityFoundException.
        catch (Exception exception) {
            throw new EntityFoundException("getCrmLogsByUserId() method of the CrmLogAccessorServiceImpl class", "Exception thrown while retrieving the list of CrmLogEntity", exception.getMessage());
        }

    }

    @Override
    public Optional<CrmLogEntityDto> getCrmLogById(Long id) throws EntityFoundException {

        // Try to get crm log by id.
        try {

            // Call findById() method of CrmLogEntityRepository to get crm log by id.
            var foundedCrmLogEntity = crmLogEntityRepository.findById(id);

            // Map the founded CrmLogEntity to a CrmLogEntityDto if foundedCrmLogEntity is not null and return it.
            return foundedCrmLogEntity.map(crmLogEntity -> MapperHelper.map(crmLogEntity, CrmLogEntityDto.class));

        }

        // Catch MappingException and throw EntityFoundException.
        catch (MappingException mappingException) {
            throw new EntityFoundException("getCrmLog(Long id) method of the CrmLogAccessorServiceImpl class", "MappingException thrown while mapping the CrmLogEntity to a CrmLogEntityDto", mappingException.getMessage());
        }

        // Catch Exception and throw EntityFoundException.
        catch (Exception exception) {
            throw new EntityFoundException("getCrmLog(Long id) method of the CrmLogAccessorServiceImpl class", "Exception thrown while retrieving the CrmLogEntity", exception.getMessage());
        }

    }

    @Override
    public Optional<CrmLogEntityDto> getCrmLogByUuid(UUID uuid) throws EntityFoundException {

        // Try to get crm log by uuid.
        try {

            // Call findByUuid() method of CrmLogEntityRepository to get crm log by uuid.
            var foundedCrmLogEntity = crmLogEntityRepository.findByUuid(uuid);

            // Map the founded CrmLogEntity to a CrmLogEntityDto if foundedCrmLogEntity is not null and return it.
            return foundedCrmLogEntity.map(crmLogEntity -> MapperHelper.map(crmLogEntity, CrmLogEntityDto.class));

        }

        // Catch MappingException and throw EntityFoundException.
        catch (MappingException mappingException) {
            throw new EntityFoundException("getCrmLog(UUID uuid) method of the CrmLogAccessorServiceImpl class", "MappingException thrown while mapping the CrmLogEntity to a CrmLogEntityDto", mappingException.getMessage());
        }

        // Catch Exception and throw EntityFoundException.
        catch (Exception exception) {
            throw new EntityFoundException("getCrmLog(UUID uuid) method of the CrmLogAccessorServiceImpl class", "Exception thrown while retrieving the CrmLogEntity", exception.getMessage());
        }

    }

}
