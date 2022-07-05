package uk.co.speedypos.epp_log_service.controllers.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import uk.co.speedypos.epp_log_service.controllers.interfaces.LogAccessorController;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;
import uk.co.speedypos.epp_log_service.models.response.internal.LogInternalResponse;
import uk.co.speedypos.epp_log_service.services.interfaces.LogAccessorService;

import java.util.List;

/**
 * Implementation of {@link LogAccessorController}.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Component
@RequiredArgsConstructor
public class LogAccessorControllerImpl implements LogAccessorController {

    private final LogAccessorService logAccessorService;

    @Override
    public ResponseEntity<List<LogInternalResponse>> getAllLogs() throws EntityFoundException {
        // todo: will be implemented in the future
        return null;
    }

    @Override
    public ResponseEntity<LogInternalResponse> getLogById(Long id) throws EntityFoundException {
        // todo: will be implemented in the future
        return null;
    }
}
