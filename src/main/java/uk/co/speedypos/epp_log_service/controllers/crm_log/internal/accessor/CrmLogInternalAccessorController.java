package uk.co.speedypos.epp_log_service.controllers.crm_log.internal.accessor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.speedypos.epp_log_service.consts.ApiPath;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;
import uk.co.speedypos.epp_log_service.models.response.crm_log.internal.CrmLogInternalResponse;

import java.util.List;
import java.util.Optional;

/**
 * Core interface for handling crm log internal accessing requests.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(ApiPath.CRM_LOG_INTERNAL_REST_PATH)
public interface CrmLogInternalAccessorController {

    /**
     * Get all crm logs.
     *
     * @return List of {@link CrmLogInternalResponse} as ResponseEntity.
     * @throws EntityFoundException Thrown when any exception occurs during the handling of internal get all crm logs request.
     * @since 1.0
     */
    @GetMapping
    ResponseEntity<List<CrmLogInternalResponse>> getCrmLogs() throws EntityFoundException;

    /**
     * Get all crm logs by user id.
     *
     * @param userId User id.
     * @return List of {@link CrmLogInternalResponse} as ResponseEntity.
     * @throws EntityFoundException Thrown when any exception occurs during the handling of internal get all crm user logs request.
     * @since 1.0
     */
    @GetMapping("/user/{userId}")
    ResponseEntity<List<CrmLogInternalResponse>> getCrmLogsByUserId(@PathVariable Long userId) throws EntityFoundException;

    /**
     * Get crm log by its id.
     *
     * @param id (@PathVariable Long) This is the id of the crm log that is going to be retrieved.
     * @return {@link CrmLogInternalResponse} object as ResponseEntity.
     * @throws EntityFoundException Thrown when any exception occurs during the handling of internal get crm log by id request.
     * @since 1.0
     */
    @GetMapping("/{id}")
    ResponseEntity<Optional<CrmLogInternalResponse>> getCrmLogById(@PathVariable Long id) throws EntityFoundException;

}
