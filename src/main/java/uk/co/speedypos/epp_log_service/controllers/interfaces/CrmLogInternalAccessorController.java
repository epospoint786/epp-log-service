package uk.co.speedypos.epp_log_service.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.speedypos.epp_log_service.consts.ApiPath;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityFoundException;
import uk.co.speedypos.epp_log_service.models.response.internal.crm.CrmLogInternalResponse;

import java.util.List;
import java.util.UUID;

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
     * @return ResponseEntity List of {@link CrmLogInternalResponse}
     * @throws EntityFoundException Thrown when any exception occurs during the handling of internal get all crm logs request.
     * @since 1.0
     */
    @GetMapping
    ResponseEntity<List<CrmLogInternalResponse>> getAllCrmLogs() throws EntityFoundException;

    /**
     * Get crm log by its id.
     *
     * @param id (@PathVariable Long) This is the id of the crm log that is going to be retrieved.
     * @return ResponseEntity {@link CrmLogInternalResponse}
     * @throws EntityFoundException Thrown when any exception occurs during the handling of internal get crm log by id request.
     * @since 1.0
     */
    @GetMapping("/{id}")
    ResponseEntity<CrmLogInternalResponse> getCrmLog(@PathVariable Long id) throws EntityFoundException;

    /**
     * Get crm logs by its UUID.
     *
     * @param uuid (@PathVariable UUID) This is the UUID of the crm log that is going to be retrieved.
     * @return ResponseEntity {@link CrmLogInternalResponse}
     * @throws EntityFoundException Thrown when any exception occurs during the handling of internal get crm log by UUID request.
     */
    @GetMapping("/{uuid}")
    ResponseEntity<CrmLogInternalResponse> getCrmLog(@PathVariable UUID uuid) throws EntityFoundException;

}
