package uk.co.speedypos.epp_log_service.exceptions;

import lombok.ToString;

/**
 * This is the base class for all exceptions thrown by the microservice.
 *
 * <p>
 *     <b>Important:</b> This class shared by all microservices
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
@ToString
public class MicroserviceException extends RuntimeException {

    private final String reference;
    private final String fullUrl;
    private final String message;
    private final String localizedMessage;
    private final String customMessage;
    private final String serviceName;
    private final Double serviceVersion;
    private final StackTraceElement[] stackTrace;
    private final String baseUserId;

    public MicroserviceException(String customMessage, String reference, Throwable throwable) {

        super(throwable.getMessage(), throwable);
        this.reference = reference;
        this.fullUrl = "";
        this.message = throwable.getMessage();
        this.localizedMessage = throwable.getLocalizedMessage();
        this.customMessage = customMessage;
        this.serviceName = "epp-log-service";
        this.serviceVersion = 1.0;
        this.stackTrace = throwable.getStackTrace();
        this.baseUserId = "";

    }
}

