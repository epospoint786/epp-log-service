package uk.co.speedypos.epp_log_service.controllers.log.internal.mq.mutator;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.speedypos.epp_log_service.exceptions.entities.EntityCreateException;
import uk.co.speedypos.epp_log_service.models.request.log.internal.mq.LogCreateRequest;
import uk.co.speedypos.epp_log_service.models.response.outgoing.log.internal.http.LogResponse;

import javax.validation.Valid;

import static uk.co.speedypos.epp_log_service.consts.ApiPath.V1_LOG_INTERNAL_HTTP_MUTATOR;
import static uk.co.speedypos.epp_log_service.consts.RabbitMQ.EPP_LOGS_LOG_QUEUE;

/**
 * Core interface for handling log external http mutating operations.
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping(V1_LOG_INTERNAL_HTTP_MUTATOR)
public interface LogMutatorController {

    /**
     * Create new log.
     *
     * @param logCreateRequest The {@link LogCreateRequest} object to be created.
     * @return Mono of ResponseEntity of {@link LogResponse} object that has been created.
     * @throws EntityCreateException if failed to create log.
     * @since 1.0.0
     */
    @RabbitListener(queues = EPP_LOGS_LOG_QUEUE)
    void createLog(@Valid LogCreateRequest logCreateRequest) throws EntityCreateException;
}
