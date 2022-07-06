package uk.co.speedypos.epp_log_service.services.crm_log.mutator;

import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.entities.CrmLogEntity;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityDeleteException;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityUpdateException;

/**
 * Core interface for {@link CrmLogEntity} mutation operations.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
public interface CrmLogMutatorService {

    /**
     * Create a new crm log.
     *
     * @param crmLogEntityDto ({@link CrmLogEntityDto}) This is the crm log that is going to be created.
     * @return The created {@link CrmLogEntityDto} object.
     * @throws EntityCreateException Thrown when any exception occurs during the creation of a crm log.
     * @since 1.0
     */
    CrmLogEntityDto createCrmLog(CrmLogEntityDto crmLogEntityDto) throws EntityCreateException;

    /**
     * Update an existing crm log.
     *
     * @param crmLogEntityDto ({@link CrmLogEntityDto}) This is the crm log that is going to be updated.
     * @return The updated {@link CrmLogEntityDto} object.
     * @throws EntityUpdateException Thrown when any exception occurs during the update of a crm log.
     * @since 1.0
     */
    CrmLogEntityDto updateCrmLog(CrmLogEntityDto crmLogEntityDto) throws EntityUpdateException;

    /**
     * Delete an existing crm log.
     *
     * @param crmLogEntityDto ({@link CrmLogEntityDto}) This is the crm log that is going to be deleted.
     * @return The deleted {@link CrmLogEntityDto} object.
     * @throws EntityDeleteException Thrown when any exception occurs during the deletion of a crm log.
     * @since 1.0
     */
    CrmLogEntityDto deleteCrmLog(CrmLogEntityDto crmLogEntityDto) throws EntityDeleteException;

}
