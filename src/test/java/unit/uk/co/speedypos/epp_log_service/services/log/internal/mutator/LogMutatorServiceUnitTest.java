package uk.co.speedypos.epp_log_service.services.log.internal.mutator;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import uk.co.speedypos.epp_log_service.DTOs.LogDTO;
import uk.co.speedypos.epp_log_service.documents.LogDocument;
import uk.co.speedypos.epp_log_service.enums.LogType;
import uk.co.speedypos.epp_log_service.helpers.MapperHelper;
import uk.co.speedypos.epp_log_service.repositories.LogMutatorRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static uk.co.speedypos.epp_log_service.helpers.DateTimeHelper.getInstantNow;

/**
 * Test for {@link LogMutatorServiceImpl} business logic.
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
@SpringBootTest(classes = LogMutatorService.class)
@DisplayName("Test log external accessor service layer business logic")
class LogMutatorServiceUnitTest {

    @MockBean
    private LogMutatorRepository logMutatorRepository;

    private LogMutatorService logMutatorService;

    private LogDocument logDocument;

    private LogDTO logDTO;

    @BeforeEach
    void setUp() {
        // Instantiate LogMutatorServiceImpl object and assign it to logMutatorService field.
        logMutatorService = new LogMutatorServiceImpl(logMutatorRepository);
        
        // Instantiate LogDocument object and assign it to logDocument field.
        logDocument = new LogDocument();
        logDocument.setTitle("Test title");
        logDocument.setDescription("Test description");
        logDocument.setLogType(LogType.SUCCESS);
        logDocument.setBaseUserId("62fba631bb0b3972c155c137");
        logDocument.setPlatformId("62fba631bb0b3972c155c137");

        logDocument.setId(new ObjectId().toHexString());
        logDocument.setUuid(UUID.randomUUID());
        logDocument.setIsTrashed(false);
        logDocument.setTotalModifyCount(0L);
        logDocument.setCreatedTimestamp(getInstantNow());
        logDocument.setLastModifiedTimestamp(null);
        logDocument.setTrashedTimestamp(null);
        
        // Map logDocument to LogDTO object and assign it to logDTO field.
        logDTO = MapperHelper.map(logDocument, LogDTO.class);
    }

    @Test
    @DisplayName("Should save LogDTO and return saved LogDTO object when saveLog() method is called")
    void saveLog() {
        // Mock save() method of logMutatorRepository and Mono of LogDocument object.
        when(logMutatorRepository.save(any(LogDocument.class))).thenReturn(Mono.just(logDocument));

        // Step verifier to test saveLog() method.
        StepVerifier.create(logMutatorService.saveLog(logDTO))
                .consumeNextWith(nextDTO -> {
                    // Assert that field length is equal to 11.
                    assertThat(nextDTO.getFieldsLength()).isEqualTo(11);

                    // Assert that the title field value is equal to "Test title".
                    assertThat(nextDTO.getTitle()).isEqualTo("Test title");

                    // Assert that the description field value is equal to "Test description".
                    assertThat(nextDTO.getDescription()).isEqualTo("Test description");

                    // Assert that the baseUserId field value is equal to "62fba631bb0b3972c155c137".
                    assertThat(nextDTO.getBaseUserId()).isEqualTo("62fba631bb0b3972c155c137");

                    // Assert that the platformId field value is equal to "62fba631bb0b3972c155c137".
                    assertThat(nextDTO.getPlatformId()).isEqualTo("62fba631bb0b3972c155c137");

                    // Assert that the logType field value is equal to LogType.SUCCESS.
                    assertThat(nextDTO.getLogType()).isEqualTo(LogType.SUCCESS);

                    // Assert base fields.
                    assertThat(nextDTO.getId()).isEqualTo(logDTO.getId());
                    assertThat(nextDTO.getUuid()).isEqualTo(logDTO.getUuid());
                    assertThat(nextDTO.getIsTrashed()).isEqualTo(logDTO.getIsTrashed());
                    assertThat(nextDTO.getTotalModifyCount()).isEqualTo(logDTO.getTotalModifyCount());
                    assertThat(nextDTO.getCreatedTimestamp()).isEqualTo(logDTO.getCreatedTimestamp());
                    assertThat(nextDTO.getLastModifiedTimestamp()).isEqualTo(logDTO.getLastModifiedTimestamp());
                    assertThat(nextDTO.getTrashedTimestamp()).isEqualTo(logDTO.getTrashedTimestamp());
                })
                .verifyComplete();

        // Verify that save() method of logMutatorRepository is called once.
        verify(logMutatorRepository).save(any(LogDocument.class));
    }
}