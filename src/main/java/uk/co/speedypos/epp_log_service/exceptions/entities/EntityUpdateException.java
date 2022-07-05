package uk.co.speedypos.epp_log_service.exceptions.entities;

public class EntityUpdateException extends EntityCrudException {
    public EntityUpdateException(String method, String occurred, String message) {
        super(method, occurred, message);
    }
}
