package uk.co.speedypos.epp_log_service.helpers;

/**
 * This class for util methods used in the application.
 *
 * <p>
 * This class is a singleton class.
 * It is used to provide utility methods to other classes.
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
public class StringHelper {

    /**
     * This method is used to convert camel case to snake case.
     *
     * @param camelCase camel case string
     * @return snake case string
     * @author Supto Purakayasto
     * @since 1.0
     */
    public static String convertCamelCaseToSnakeCase(String camelCase) {
        return camelCase.replaceAll("([A-Z])", "_$1").toLowerCase();
    }

    /**
     * This method is used to convert snake case to camel case.
     *
     * @param snakeCase snake case string
     * @return camel case string
     * @author Supto Purakayasto
     * @since 1.0
     */
    public static String convertSnakeCaseToCamelCase(String snakeCase) {
        return snakeCase.replaceAll("_([a-z])", "$1").toLowerCase();
    }

    /**
     * This method is used to convert text to snake case.
     *
     * @param text text string
     * @author Supto Purakayasto
     * @since 1.0
     */
    public static String convertTextToSnakeCase(String text) {
        return text.replaceAll("([A-Z])", "_$1").toLowerCase();
    }
}
