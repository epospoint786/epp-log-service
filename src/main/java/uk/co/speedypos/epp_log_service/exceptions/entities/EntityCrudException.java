package uk.co.speedypos.epp_log_service.exceptions.entities;


import uk.co.speedypos.epp_log_service.exceptions.MicroserviceException;

public class EntityCrudException extends MicroserviceException {

    public EntityCrudException(String method, String occurred, String message) {
        super(method, occurred, message);
    }

}
