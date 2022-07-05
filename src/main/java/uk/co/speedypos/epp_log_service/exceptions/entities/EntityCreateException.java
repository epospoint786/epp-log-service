package uk.co.speedypos.epp_log_service.exceptions.entities;

public class EntityCreateException extends EntityCrudException {
    public EntityCreateException(String method, String occurred, String message) {
        super(method, occurred, message);
    }
}
