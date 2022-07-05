package uk.co.speedypos.epp_log_service.controllers.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import uk.co.speedypos.epp_log_service.controllers.interfaces.CrmLogInternalAccessorController;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;
import uk.co.speedypos.epp_log_service.models.response.internal.crm.CrmLogInternalResponse;
import uk.co.speedypos.epp_log_service.services.interfaces.crm.CrmLogAccessorService;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<List<CrmLogInternalResponse>> getAllCrmLogs() throws EntityFoundException {

        // todo: will be implemented in the future
        return null;

    }

    @Override
    public ResponseEntity<CrmLogInternalResponse> getCrmLog(Long id) throws EntityFoundException {

        // todo: will be implemented in the future
        return null;

    }

    @Override
    public ResponseEntity<CrmLogInternalResponse> getCrmLog(UUID uuid) throws EntityFoundException {

        // todo: will be implemented in the future
        return null;

    }
}
