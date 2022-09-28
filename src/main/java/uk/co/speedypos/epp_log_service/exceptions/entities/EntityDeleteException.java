package uk.co.speedypos.epp_log_service.exceptions.entities;

/**
 * This exception is thrown when an entity deletion fails.
 *
 * <p>
 *     <b>Important:</b> This class shared by all microservices
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
public class EntityDeleteException extends EntityCrudException {

    public EntityDeleteException(String customMessage, String reference, Throwable throwable) {
        super(customMessage, reference, throwable);
    }

}
