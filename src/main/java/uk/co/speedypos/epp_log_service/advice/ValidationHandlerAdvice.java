package uk.co.speedypos.epp_log_service.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uk.co.speedypos.epp_log_service.helpers.StringHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to handle ValidationException thrown by the application.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@ControllerAdvice
public class ValidationHandlerAdvice extends ResponseEntityExceptionHandler {

    /**
     * This method is used to handle MethodArgumentNotValidException thrown by the application.
     *
     * @param ex MethodArgumentNotValidException
     * @param headers   HttpHeaders
     * @param status    HttpStatus
     * @param request   WebRequest
     * @return ResponseEntity with HttpStatus.BAD_REQUEST and error message
     * @since 1.0
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                 .getFieldErrors()
                 .forEach(error -> errors.put(StringHelper.convertCamelCaseToSnakeCase(error.getField()),
                         error.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }
}
