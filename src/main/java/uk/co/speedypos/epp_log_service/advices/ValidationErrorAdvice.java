package uk.co.speedypos.epp_log_service.advices;

import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

import static uk.co.speedypos.epp_log_service.helpers.StringHelper.convertCamelCaseToSnakeCase;

@RestControllerAdvice
public class ValidationErrorAdvice {

    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<Object>> handleValidationError(WebExchangeBindException ex, ServerHttpRequest serverHttpRequest) {
        Map<String, String> errors = new HashMap<>();

        if(serverHttpRequest.getURI().toString().contains("internal")) {
            ex.getBindingResult().getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
        } else {
            ex.getBindingResult().getFieldErrors().forEach(error ->
                    errors.put(convertCamelCaseToSnakeCase(error.getField()), error.getDefaultMessage()));
        }

        return Mono.just(ResponseEntity.badRequest().body(errors));
    }
}