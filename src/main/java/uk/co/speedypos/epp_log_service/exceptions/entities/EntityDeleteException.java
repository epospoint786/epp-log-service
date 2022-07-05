package uk.co.speedypos.epp_log_service.exceptions.entities;

public class EntityDeleteException extends EntityCrudException {
    public EntityDeleteException(String method, String occurred, String message) {
        super(method, occurred, message);
    }
}
