package uk.co.speedypos.epp_log_service.controllers.crm_log.internal.mutator;

import lombok.RequiredArgsConstructor;
import org.modelmapper.MappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityUpdateException;
import uk.co.speedypos.epp_log_service.helpers.MapperHelper;
import uk.co.speedypos.epp_log_service.models.request.crm_log.internal.CrmLogInternalCreateRequest;
import uk.co.speedypos.epp_log_service.models.request.crm_log.internal.CrmLogInternalDeleteRequest;
import uk.co.speedypos.epp_log_service.models.request.crm_log.internal.CrmLogInternalUpdateRequest;
import uk.co.speedypos.epp_log_service.models.response.crm_log.internal.CrmLogInternalResponse;
import uk.co.speedypos.epp_log_service.services.crm_log.mutator.CrmLogMutatorService;

/**
 * Implementation of {@link CrmLogInternalMutatorController} interface.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class CrmLogInternalMutatorControllerImpl implements CrmLogInternalMutatorController {

    private final CrmLogMutatorService crmLogMutatorService;

    @Override
    public ResponseEntity<CrmLogInternalResponse> createCrmLog(CrmLogInternalCreateRequest crmLogInternalCreateRequest) throws EntityCreateException {

        // Try to create crm log.
        try {
            // Map crmLogInternalCreateRequest to CrmLogEntityDto.
            var mappedCrmLogEntityDto = MapperHelper.map(crmLogInternalCreateRequest, CrmLogEntityDto.class);

            // Call createCrmLog() method of CrmLogMutatorService to create crm log.
            var createdCrmLogEntityDto = crmLogMutatorService.createCrmLog(mappedCrmLogEntityDto);

            // Map the createdCrmLogEntityDto to a CrmLogInternalResponse.
            var mappedCrmLogInternalResponse = MapperHelper.map(createdCrmLogEntityDto, CrmLogInternalResponse.class);

            // Return the mappedCrmLogInternalResponse.
            return ResponseEntity.status(HttpStatus.CREATED).body(mappedCrmLogInternalResponse);

        }

        // Catch MappingException and throw EntityCreateException.
        catch (MappingException mappingException) {
            throw new EntityCreateException("createCrmLog() method of the CrmLogInternalMutatorControllerImpl class", "MappingException thrown while mapping (CrmLogInternalCreateRequest to CrmLogEntityDto) or (CrmLogEntityDto to CrmLogInternalResponse)", mappingException.getMessage());
        }

        // Rethrow EntityCreateException.
        catch (EntityCreateException entityCreateException) {
            throw entityCreateException;
        }

        // Catch Exception and throw EntityCreateException.
        catch (Exception exception) {
            throw new EntityCreateException("createCrmLog() method of the CrmLogInternalMutatorControllerImpl class", "Exception thrown while creating the CrmLogEntityDto", exception.getMessage());
        }

    }

    @Override
    public ResponseEntity<CrmLogInternalResponse> updateCrmLog(CrmLogInternalUpdateRequest crmLogInternalUpdateRequest) throws EntityUpdateException {

        // Try to update crm log.
        try {
            // Map crmLogInternalUpdateRequest to CrmLogEntityDto.
            var mappedCrmLogEntityDto = MapperHelper.map(crmLogInternalUpdateRequest, CrmLogEntityDto.class);

            // Call updateCrmLog() method of CrmLogMutatorService to update crm log.
            var updatedCrmLogEntityDto = crmLogMutatorService.updateCrmLog(mappedCrmLogEntityDto);

            // Map the updatedCrmLogEntityDto to a CrmLogInternalResponse.
            var mappedCrmLogInternalResponse = MapperHelper.map(updatedCrmLogEntityDto, CrmLogInternalResponse.class);

            // Return the mappedCrmLogInternalResponse.
            return ResponseEntity.status(HttpStatus.OK).body(mappedCrmLogInternalResponse);

        }

        // Catch MappingException and throw EntityUpdateException.
        catch (MappingException mappingException) {
            throw new EntityUpdateException("updateCrmLog() method of the CrmLogInternalMutatorControllerImpl class", "MappingException thrown while mapping (CrmLogInternalUpdateRequest to CrmLogEntityDto) or (CrmLogEntityDto to CrmLogInternalResponse)", mappingException.getMessage());
        }

        // Rethrow EntityUpdateException.
        catch (EntityUpdateException entityUpdateException) {
            throw entityUpdateException;
        }

        // Catch Exception and throw EntityUpdateException.
        catch (Exception exception) {
            throw new EntityUpdateException("updateCrmLog() method of the CrmLogInternalMutatorControllerImpl class", "Exception thrown while updating the CrmLogEntityDto", exception.getMessage());
        }


    }

    @Override
    public ResponseEntity<CrmLogInternalResponse> deleteCrmLog(CrmLogInternalDeleteRequest crmLogInternalDeleteRequest) throws EntityUpdateException {

        // Try to delete crm log.
        try {
            // Map crmLogInternalDeleteRequest to CrmLogEntityDto.
            var mappedCrmLogEntityDto = MapperHelper.map(crmLogInternalDeleteRequest, CrmLogEntityDto.class);

            // Call deleteCrmLog() method of CrmLogMutatorService to delete crm log.
            var deletedCrmLogEntityDto = crmLogMutatorService.deleteCrmLog(mappedCrmLogEntityDto);

            // Map the deletedCrmLogEntityDto to a CrmLogInternalResponse.
            var mappedCrmLogInternalResponse = MapperHelper.map(deletedCrmLogEntityDto, CrmLogInternalResponse.class);

            // Return the mappedCrmLogInternalResponse.
            return ResponseEntity.status(HttpStatus.OK).body(mappedCrmLogInternalResponse);

        }

        // Catch MappingException and throw EntityUpdateException.
        catch (MappingException mappingException) {
            throw new EntityUpdateException("deleteCrmLog() method of the CrmLogInternalMutatorControllerImpl class", "MappingException thrown while mapping (CrmLogInternalDeleteRequest to CrmLogEntityDto) or (CrmLogEntityDto to CrmLogInternalResponse)", mappingException.getMessage());
        }

        // Rethrow EntityUpdateException.
        catch (EntityUpdateException entityUpdateException) {
            throw entityUpdateException;
        }

        // Catch Exception and throw EntityUpdateException.
        catch (Exception exception) {
            throw new EntityUpdateException("deleteCrmLog() method of the CrmLogInternalMutatorControllerImpl class", "Exception thrown while deleting the CrmLogEntityDto", exception.getMessage());
        }


    }
}
