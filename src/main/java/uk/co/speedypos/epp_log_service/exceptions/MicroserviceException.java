package uk.co.speedypos.epp_log_service.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * This exception is used to create a common exception for all microservices.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
public class MicroserviceException extends RuntimeException {

    private final Long userId;
//    private final UserType userType;
    private final String method;
    private final String occurred;
//    private final String url;
    private final String microservice;

    public MicroserviceException(String method, String occurred, String message) {
        super(message);
//        this.userId = AuthHelper.getAuthenticatedUserId();
        this.userId = null;
//        this.userType = UserType.CRM;
        this.method = method;
        this.occurred = occurred;
//        this.url = HttpHelper.getCurrentHttpRequestUrl();
        this.microservice = "";
    }
}

