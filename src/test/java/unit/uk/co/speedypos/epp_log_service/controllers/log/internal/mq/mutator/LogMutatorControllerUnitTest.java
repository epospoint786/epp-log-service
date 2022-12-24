package uk.co.speedypos.epp_log_service.controllers.log.internal.mq.mutator;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import uk.co.speedypos.epp_log_service.DTOs.LogDTO;
import uk.co.speedypos.epp_log_service.enums.LogType;
import uk.co.speedypos.epp_log_service.helpers.MapperHelper;
import uk.co.speedypos.epp_log_service.models.response.outgoing.log.internal.http.LogResponse;
import uk.co.speedypos.epp_log_service.services.log.internal.mutator.LogMutatorService;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static uk.co.speedypos.epp_log_service.consts.ApiPath.V1_LOG_INTERNAL_HTTP_MUTATOR;
import static uk.co.speedypos.epp_log_service.helpers.DateTimeHelper.getInstantNow;

@WebFluxTest(controllers = LogMutatorController.class, excludeAutoConfiguration = ReactiveSecurityAutoConfiguration.class)
@AutoConfigureWebTestClient
@DisplayName("Test log external http accessor controller layer")
class LogMutatorControllerUnitTest {

    @MockBean
    private LogMutatorService logMutatorService;

    @Autowired
    private WebTestClient webTestClient;

    private LogDTO logDTO;

    private LogResponse logResponse;

    @BeforeEach
    void setUp() {

        // Instantiate LogDTO object and assign it to logDTO field.
        logDTO = new LogDTO();
        logDTO.setTitle("Test title");
        logDTO.setDescription("Test description");
        logDTO.setBaseUserId("62fba631bb0b3972c155c137");
        logDTO.setPlatformId("62fba631bb0b3972c155c137");
        logDTO.setLogType(LogType.SUCCESS);

        logDTO.setId(new ObjectId().toHexString());
        logDTO.setUuid(UUID.randomUUID());
        logDTO.setIsTrashed(false);
        logDTO.setTotalModifyCount(1L);
        logDTO.setCreatedTimestamp(getInstantNow());
        logDTO.setLastModifiedTimestamp(getInstantNow());
        logDTO.setTrashedTimestamp(null);

        // Map logDTO to LogResponse object and assign it to logResponse field.
        logResponse = MapperHelper.map(logDTO, LogResponse.class);
    }
    @Test
    @DisplayName("Should create log and return Mono of ResponseEntity of LogResponse object with status code 201 when POST request sent to " + V1_LOG_INTERNAL_HTTP_MUTATOR)
    void createLog() {

        // Mock saveLog method of logMutatorService  to return Mono of LogDTO object.
        when(logMutatorService.saveLog(any(LogDTO.class))).thenReturn(Mono.just(logDTO));

        // Send POST request to V1_LOG_INTERNAL_HTTP_MUTATOR and expect status code 201.
        webTestClient.post()
                .uri(V1_LOG_INTERNAL_HTTP_MUTATOR)
                .accept(APPLICATION_JSON)
                .body(Mono.just(logDTO), LogDTO.class)
                .exchange()

                // Expect a successful response with status code 201.
                .expectStatus().isCreated()

                // Expect content type application/json.
                .expectHeader().contentType(APPLICATION_JSON)

                .expectBody()

                // Expect keys size to be equal to 11.
                .jsonPath("$.size()").isEqualTo(11)

                // Expect the "title" key contains value "Test title".
                .jsonPath("$.title").isEqualTo("Test title")

                // Expect the "description" key contains value "Test description".
                .jsonPath("$.description").isEqualTo("Test description")

                // Expect the "baseUserId" key contains value "62fba631bb0b3972c155c137".
                .jsonPath("$.baseUserId").isEqualTo("62fba631bb0b3972c155c137")

                // Expect the "platformId" key contains value "62fba631bb0b3972c155c137".
                .jsonPath("$.platformId").isEqualTo("62fba631bb0b3972c155c137")

                // Expect the "logType" key contains value "SUCCESS".
                .jsonPath("$.logType").isEqualTo("SUCCESS")

                /// Expecting base keys.
                .jsonPath("$.id").isEqualTo(logResponse.getId())
                .jsonPath("$.uuid").isEqualTo(logResponse.getUuid().toString())
                .jsonPath("$.isTrashed").isEqualTo(logResponse.getIsTrashed())
                .jsonPath("$.totalModifyCount").isEqualTo(logResponse.getTotalModifyCount())
                .jsonPath("$.createdTimestamp").isEqualTo(logResponse.getCreatedTimestamp().toString())
                .jsonPath("$.lastModifiedTimestamp").isEqualTo(logResponse.getLastModifiedTimestamp().toString())
                .jsonPath("$.trashedTimestamp").isEqualTo(logResponse.getTrashedTimestamp());

        // Verify that saveLog method of logMutatorService was called once.
        verify(logMutatorService).saveLog(any(LogDTO.class));
    }
}