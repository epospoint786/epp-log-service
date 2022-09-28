package uk.co.speedypos.epp_log_service.exceptions.entities;


import uk.co.speedypos.epp_log_service.exceptions.MicroserviceException;

/**
 * This is the base class for all entity crud exceptions.
 *
 * <p>
 *     <b>Important:</b> This class shared by all microservices
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
public class EntityCrudException extends MicroserviceException {

    public EntityCrudException(String customMessage, String reference, Throwable throwable) {
        super(customMessage, reference, throwable);
    }

}
