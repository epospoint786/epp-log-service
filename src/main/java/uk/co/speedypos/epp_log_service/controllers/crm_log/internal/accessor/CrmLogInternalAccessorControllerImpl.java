package uk.co.speedypos.epp_log_service.controllers.crm_log.internal.accessor;

import lombok.RequiredArgsConstructor;
import org.modelmapper.MappingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;
import uk.co.speedypos.epp_log_service.helpers.MapperHelper;
import uk.co.speedypos.epp_log_service.models.response.crm_log.internal.CrmLogInternalResponse;
import uk.co.speedypos.epp_log_service.services.crm_log.accessor.CrmLogAccessorService;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link CrmLogInternalAccessorController} interface.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Component
@RequiredArgsConstructor
public class CrmLogInternalAccessorControllerImpl implements CrmLogInternalAccessorController {

    private final CrmLogAccessorService crmLogAccessorService;

    @Override
    public ResponseEntity<List<CrmLogInternalResponse>> getCrmLogs() throws EntityFoundException {

        // Try to get all crm logs.
        try {

            // Call getCrmLogs() method of CrmLogAccessorService to get all crm logs.
            var foundedCrmLogInternalResponseList = crmLogAccessorService.getCrmLogs();

            // Map the founded list of CrmLogEntityDto to a list of CrmLogInternalResponse.
            var crmLogInternalResponseList = MapperHelper.mapList(foundedCrmLogInternalResponseList, CrmLogInternalResponse.class);

            return ResponseEntity.ok(crmLogInternalResponseList);

        }

        // Catch MappingException and throw EntityFoundException.
        catch (MappingException mappingException) {
            throw new EntityFoundException("getCrmLogs() method of the CrmLogInternalAccessorControllerImpl class", "MappingException thrown while mapping the list of CrmLogEntityDto to a list of CrmLogInternalResponse", mappingException.getMessage());
        }

        // Rethrow EntityFoundException.
        catch (EntityFoundException entityFoundException) {
            throw entityFoundException;
        }

        // Catch Exception and throw EntityFoundException.
        catch (Exception exception) {
            throw new EntityFoundException("getCrmLogs() method of the CrmLogInternalAccessorControllerImpl class", "Exception thrown while retrieving the list of CrmLogEntityDto", exception.getMessage());
        }


    }

    @Override
    public ResponseEntity<List<CrmLogInternalResponse>> getCrmLogsByUserId(Long userId) throws EntityFoundException {

        // Try to get all crm logs by user id.
        try {

            // Call getCrmLogsByUserId method of CrmLogAccessorService to get all crm logs by user id.
            var foundedCrmLogInternalResponseList = crmLogAccessorService.getCrmLogsByUserId(userId);

            // Map the founded list of CrmLogEntityDto to a list of CrmLogInternalResponse.
            var crmLogInternalResponseList = MapperHelper.mapList(foundedCrmLogInternalResponseList, CrmLogInternalResponse.class);

            return ResponseEntity.ok(crmLogInternalResponseList);

        }

        // Catch MappingException and throw EntityFoundException.
        catch (MappingException mappingException) {
            throw new EntityFoundException("getCrmLogsByUserId() method of the CrmLogInternalAccessorControllerImpl class", "MappingException thrown while mapping the list of CrmLogEntityDto to a list of CrmLogInternalResponse", mappingException.getMessage());
        }

        // Rethrow EntityFoundException.
        catch (EntityFoundException entityFoundException) {
            throw entityFoundException;
        }

        // Catch Exception and throw EntityFoundException.
        catch (Exception exception) {
            throw new EntityFoundException("getCrmLogsByUserId() method of the CrmLogInternalAccessorControllerImpl class", "Exception thrown while retrieving the list of CrmLogEntityDto", exception.getMessage());
        }

    }

    @Override
    public ResponseEntity<Optional<CrmLogInternalResponse>> getCrmLogById(Long id) throws EntityFoundException {

        // Try to get crm log by id.
        try {

            // Call getCrmLogById() method of CrmLogAccessorService to get crm log by id.
            var foundedCrmLogEntityDto = crmLogAccessorService.getCrmLogById(id);

            // Map the founded CrmLogEntityDto to a CrmLogInternalResponse if foundedCrmLogEntityDto is not null.
            var crmLogInternalResponse = foundedCrmLogEntityDto.map(crmLogEntityDto -> MapperHelper.map(crmLogEntityDto, CrmLogInternalResponse.class));

            return ResponseEntity.ok(crmLogInternalResponse);

        }

        // Catch MappingException and throw EntityFoundException.
        catch (MappingException mappingException) {
            throw new EntityFoundException("getCrmLogById() method of the CrmLogInternalAccessorControllerImpl class", "MappingException thrown while mapping the CrmLogEntityDto to a CrmLogInternalResponse", mappingException.getMessage());
        }

        // Rethrow EntityFoundException.
        catch (EntityFoundException entityFoundException) {
            throw entityFoundException;
        }

        // Catch Exception and throw EntityFoundException.
        catch (Exception exception) {
            throw new EntityFoundException("getCrmLogById() method of the CrmLogInternalAccessorControllerImpl class", "Exception thrown while retrieving the CrmLogEntityDto", exception.getMessage());
        }

    }

}
