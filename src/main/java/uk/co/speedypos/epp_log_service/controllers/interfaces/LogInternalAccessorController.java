package uk.co.speedypos.epp_log_service.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.speedypos.epp_log_service.consts.ApiPath;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;
import uk.co.speedypos.epp_log_service.models.response.internal.LogInternalResponse;

import java.util.List;
import java.util.UUID;

/**
 * Core interface for handling log internal accessing requests.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(ApiPath.LOG_INTERNAL_REST_PATH)
public interface LogInternalAccessorController {

    /**
     * Get all logs.
     *
     * @return ResponseEntity List of {@link LogInternalResponse}
     * @throws EntityFoundException Thrown when any exception occurs during the handling of internal get all logs request.
     * @since 1.0
     */
    @GetMapping
    ResponseEntity<List<LogInternalResponse>> getAllLogs() throws EntityFoundException;

    /**
     * Get log by its id.
     *
     * @param id (@PathVariable Long) This is the id of the log that is going to be retrieved.
     * @return ResponseEntity {@link LogInternalResponse}
     * @throws EntityFoundException Thrown when any exception occurs during the handling of internal get log by id request.
     * @since 1.0
     */
    @GetMapping("/{id}")
    ResponseEntity<LogInternalResponse> getLog(@PathVariable Long id) throws EntityFoundException;

    /**
     * Get logs by its UUID.
     *
     * @param uuid (@PathVariable UUID) This is the UUID of the log that is going to be retrieved.
     * @return ResponseEntity {@link LogInternalResponse}
     * @throws EntityFoundException Thrown when any exception occurs during the handling of internal get log by UUID request.
     */
    @GetMapping("/{uuid}")
    ResponseEntity<LogInternalResponse> getLog(@PathVariable UUID uuid) throws EntityFoundException;

}
