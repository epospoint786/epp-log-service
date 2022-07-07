package uk.co.speedypos.epp_log_service.controllers.crm_log.internal.mutator;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.speedypos.epp_log_service.consts.ApiPath;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityUpdateException;
import uk.co.speedypos.epp_log_service.models.request.crm_log.internal.CrmLogInternalCreateRequest;
import uk.co.speedypos.epp_log_service.models.request.crm_log.internal.CrmLogInternalDeleteRequest;
import uk.co.speedypos.epp_log_service.models.request.crm_log.internal.CrmLogInternalUpdateRequest;
import uk.co.speedypos.epp_log_service.models.response.crm_log.internal.CrmLogInternalResponse;

import javax.validation.Valid;

/**
 * Core interface for handling crm log internal mutating requests.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(ApiPath.CRM_LOG_INTERNAL_REST_PATH)
public interface CrmLogInternalMutatorController {

    /**
     * Create new crm log.
     *
     * @param crmLogInternalCreateRequest ({@link CrmLogInternalCreateRequest}) This is the crm log that is going to be created.
     * @return ResponseEntity {@link CrmLogInternalResponse}
     * @throws EntityCreateException Thrown when any exception occurs during the handling of crm log internal creation request.
     * @since 1.0
     */
    @PostMapping
    ResponseEntity<CrmLogInternalResponse> createCrmLog(@RequestBody @Valid CrmLogInternalCreateRequest crmLogInternalCreateRequest) throws EntityCreateException;

    /**
     * Update existing crm log.
     *
     * @param crmLogInternalUpdateRequest ({@link CrmLogInternalUpdateRequest}) This is the crm log that is going to be updated.
     * @return ResponseEntity {@link CrmLogInternalResponse}
     * @throws EntityUpdateException Thrown when any exception occurs during the handling of crm log internal update request.
     * @since 1.0
     */
    @PutMapping
    ResponseEntity<CrmLogInternalResponse> updateCrmLog(@RequestBody @Valid CrmLogInternalUpdateRequest crmLogInternalUpdateRequest) throws EntityUpdateException;

    /**
     * Delete existing crm log.
     *
     * @param crmLogInternalDeleteRequest ({@link CrmLogInternalDeleteRequest}) This is the crm log that is going to be deleted.
     * @return ResponseEntity {@link CrmLogInternalResponse}
     * @throws EntityUpdateException Thrown when any exception occurs during the handling of crm log internal delete request.
     * @since 1.0
     */
    @DeleteMapping
    ResponseEntity<CrmLogInternalResponse> deleteCrmLog(@RequestBody @Valid CrmLogInternalDeleteRequest crmLogInternalDeleteRequest) throws EntityUpdateException;

}
