package uk.co.speedypos.epp_log_service.helpers;

/**
 * Helper class for exception handling.
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
public class ExceptionHelper {

    public static String getReference(Class<?> clazz, Throwable throwable) {
        return clazz.getCanonicalName() + "." + throwable.getStackTrace()[0].getMethodName();
    }
}
