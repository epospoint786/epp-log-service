package uk.co.speedypos.epp_log_service.consts;

/**
 * RabbitMQ constants.
 *
 * <p>
 *     <strong>Important:</strong>
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
public class RabbitMQ {
    public static final String EPP_LOGS_EXCHANGE = "epp.logs";
    public static final String EPP_LOGS_LOG_QUEUE = "epp.logs.log.queue";
    public static final String EPP_LOGS_LOG_ROUTING_KEY = "epp.logs.log.routing.key";
}
