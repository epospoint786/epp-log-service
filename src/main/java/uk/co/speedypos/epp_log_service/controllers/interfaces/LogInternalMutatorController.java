package uk.co.speedypos.epp_log_service.controllers.interfaces;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.speedypos.epp_log_service.consts.ApiPath;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityUpdateException;
import uk.co.speedypos.epp_log_service.models.request.internal.LogInternalCreateRequest;
import uk.co.speedypos.epp_log_service.models.request.internal.LogInternalDeleteRequest;
import uk.co.speedypos.epp_log_service.models.request.internal.LogInternalUpdateRequest;
import uk.co.speedypos.epp_log_service.models.response.internal.LogInternalResponse;

import javax.validation.Valid;

/**
 * Core interface for handling log internal mutating requests.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(ApiPath.LOG_INTERNAL_REST_PATH)
public interface LogInternalMutatorController {

    /**
     * Create new log.
     *
     * @param logInternalCreateRequest ({@link LogInternalCreateRequest}) This is the log that is going to be created.
     * @return ResponseEntity {@link LogInternalResponse}
     * @throws EntityCreateException Thrown when any exception occurs during the handling of log internal creation request.
     * @since 1.0
     */
    @PostMapping
    ResponseEntity<LogInternalResponse> createLog(@RequestBody @Valid LogInternalCreateRequest logInternalCreateRequest) throws EntityCreateException;

    /**
     * Update existing log.
     *
     * @param logInternalUpdateRequest ({@link LogInternalUpdateRequest}) This is the log that is going to be updated.
     * @return ResponseEntity {@link LogInternalResponse}
     * @throws EntityUpdateException Thrown when any exception occurs during the handling of log internal update request.
     * @since 1.0
     */
    @PutMapping
    ResponseEntity<LogInternalResponse> updateLog(@RequestBody @Valid LogInternalUpdateRequest logInternalUpdateRequest) throws EntityUpdateException;

    /**
     * Delete existing log.
     *
     * @param logInternalDeleteRequest ({@link LogInternalDeleteRequest}) This is the log that is going to be deleted.
     * @return ResponseEntity {@link LogInternalResponse}
     * @throws EntityUpdateException Thrown when any exception occurs during the handling of log internal delete request.
     * @since 1.0
     */
    @DeleteMapping
    ResponseEntity<LogInternalResponse> deleteLog(@RequestBody @Valid LogInternalDeleteRequest logInternalDeleteRequest) throws EntityUpdateException;

}
