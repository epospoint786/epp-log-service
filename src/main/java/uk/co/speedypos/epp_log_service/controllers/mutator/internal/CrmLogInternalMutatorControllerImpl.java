package uk.co.speedypos.epp_log_service.controllers.mutator.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityUpdateException;
import uk.co.speedypos.epp_log_service.models.request.internal.crm.CrmLogInternalCreateRequest;
import uk.co.speedypos.epp_log_service.models.request.internal.crm.CrmLogInternalDeleteRequest;
import uk.co.speedypos.epp_log_service.models.request.internal.crm.CrmLogInternalUpdateRequest;
import uk.co.speedypos.epp_log_service.models.response.internal.crm.CrmLogInternalResponse;
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

        // todo: will be implemented in future
        return null;

    }

    @Override
    public ResponseEntity<CrmLogInternalResponse> updateCrmLog(CrmLogInternalUpdateRequest crmLogInternalUpdateRequest) throws EntityUpdateException {

        // todo: will be implemented in future
        return null;

    }

    @Override
    public ResponseEntity<CrmLogInternalResponse> deleteCrmLog(CrmLogInternalDeleteRequest crmLogInternalDeleteRequest) throws EntityUpdateException {

        // todo: will be implemented in future
        return null;

    }
}
