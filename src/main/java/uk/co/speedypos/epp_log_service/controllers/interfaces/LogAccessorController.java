package uk.co.speedypos.epp_log_service.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.speedypos.epp_log_service.consts.ApiPath;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;
import uk.co.speedypos.epp_log_service.models.response.internal.LogInternalResponse;

import java.util.List;

/**
 * Core interface for handling log accessing requests.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(ApiPath.LOG_REST_PATH)
public interface LogAccessorController {

    /**
     * Get all logs.
     *
     * @return ResponseEntity List of {@link LogInternalResponse}
     * @throws EntityFoundException Thrown when any exception occurs during the handling of get all logs request.
     * @since 1.0
     */
    @RequestMapping
    ResponseEntity<List<LogInternalResponse>> getAllLogs() throws EntityFoundException;

    /**
     * Get log by its id.
     *
     * @param id This is the id of the log that is going to be retrieved.
     * @return ResponseEntity {@link LogInternalResponse}
     * @throws EntityFoundException Thrown when any exception occurs during the handling of get log by id request.
     * @since 1.0
     */
    @RequestMapping("/{id}")
    ResponseEntity<LogInternalResponse> getLogById(@PathVariable Long id) throws EntityFoundException;

}
