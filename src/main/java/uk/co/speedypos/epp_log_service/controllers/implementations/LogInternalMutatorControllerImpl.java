package uk.co.speedypos.epp_log_service.controllers.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uk.co.speedypos.epp_log_service.controllers.interfaces.LogInternalMutatorController;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityUpdateException;
import uk.co.speedypos.epp_log_service.models.request.internal.LogInternalCreateRequest;
import uk.co.speedypos.epp_log_service.models.request.internal.LogInternalDeleteRequest;
import uk.co.speedypos.epp_log_service.models.request.internal.LogInternalUpdateRequest;
import uk.co.speedypos.epp_log_service.models.response.internal.LogInternalResponse;
import uk.co.speedypos.epp_log_service.services.interfaces.LogMutatorService;

/**
 * Implementation of {@link LogInternalMutatorController} interface.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class LogInternalMutatorControllerImpl implements LogInternalMutatorController {

    private final LogMutatorService logMutatorService;

    @Override
    public ResponseEntity<LogInternalResponse> createLog(LogInternalCreateRequest logInternalCreateRequest) throws EntityCreateException {

        // todo: will be implemented in future
        return null;

    }

    @Override
    public ResponseEntity<LogInternalResponse> updateLog(LogInternalUpdateRequest logInternalUpdateRequest) throws EntityUpdateException {

        // todo: will be implemented in future
        return null;

    }

    @Override
    public ResponseEntity<LogInternalResponse> deleteLog(LogInternalDeleteRequest logInternalDeleteRequest) throws EntityUpdateException {

        // todo: will be implemented in future
        return null;

    }
}
