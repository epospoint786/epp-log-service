package uk.co.speedypos.epp_log_service.helpers;

import java.time.Instant;
import java.time.ZoneId;

/**
 * Helper class for DateTime
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
public class DateTimeHelper {


    /**
     * Get the current time in UTC.
     *
     * @return (Instant) The current time in UTC Europe/London time zone.
     * @since 1.0.0
     */
    public static Instant getInstantNow() {
        return Instant.now().atZone(ZoneId.of("Europe/London")).toInstant();
    }
}
