package uk.co.speedypos.epp_log_service.exceptions.entities;

public class EntityFoundException extends EntityCrudException {

    public EntityFoundException(String method, String occurred, String message) {
        super(method, occurred, message);
    }

}
