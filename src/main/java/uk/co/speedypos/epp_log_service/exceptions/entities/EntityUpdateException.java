package uk.co.speedypos.epp_log_service.exceptions.entities;

/**
 * This exception is thrown when an entity update fails.
 *
 * <p>
 *     <b>Important:</b> This class shared by all microservices
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
public class EntityUpdateException extends EntityCrudException {

    public EntityUpdateException(String customMessage, String reference, Throwable throwable) {
        super(customMessage, reference, throwable);
    }

}
