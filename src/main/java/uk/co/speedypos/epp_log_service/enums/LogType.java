package uk.co.speedypos.epp_log_service.enums;

/**
 * LogType enum.
 *
 * <p>
 * <b>Important:</b> This is shared by all microservices.
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
public enum LogType {

    SUCCESS,
    ERROR,
    INFO;

    /**
     * Get random LogType (only for testing purpose).
     *
     * @return LogType random LogType
     * @since 1.0
     */
    public static LogType getRandom() {

        return values()[(int) (Math.random() * values().length)];

    }

}
