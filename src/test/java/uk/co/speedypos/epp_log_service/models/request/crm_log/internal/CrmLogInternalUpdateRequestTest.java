package uk.co.speedypos.epp_log_service.models.request.crm_log.internal;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.enums.LogType;
import uk.co.speedypos.epp_log_service.services.crm_log.accessor.CrmLogAccessorService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Test for {@link CrmLogInternalCreateRequest} all fields validation constraints.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@WebMvcTest(CrmLogInternalUpdateRequest.class)
@AutoConfigureMockMvc(addFilters = false)
@DisplayName("Tests for CrmLogInternalUpdateRequest model all fields validation constraints")
@Slf4j
class CrmLogInternalUpdateRequestTest {

    @MockBean
    private CrmLogAccessorService crmLogAccessorService;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private Validator validator;

    private CrmLogInternalUpdateRequest crmLogInternalUpdateRequest;

    private CrmLogEntityDto crmLogEntityDto;

    private Set<ConstraintViolation<CrmLogInternalUpdateRequest>> violations;

    @BeforeEach
    void setUp() {

        // Initialize crmLogInternalUpdateRequest class field.
        crmLogInternalUpdateRequest = new CrmLogInternalUpdateRequest();
        crmLogInternalUpdateRequest.setId(100000000L);
        crmLogInternalUpdateRequest.setUuid(UUID.randomUUID());
        crmLogInternalUpdateRequest.setMessage("Test crm log message");
        crmLogInternalUpdateRequest.setLogType(LogType.getRandom().name());
        crmLogInternalUpdateRequest.setUserId(100000001L);

        // Initialize crmLogEntityDto class field.
        CrmLogEntityDto crmLogEntityDto = new CrmLogEntityDto();
        crmLogEntityDto.setMessage(crmLogInternalUpdateRequest.getMessage());
        crmLogEntityDto.setLogType(LogType.valueOf(crmLogInternalUpdateRequest.getLogType()));
        crmLogEntityDto.setUserId(crmLogInternalUpdateRequest.getUserId());
        crmLogEntityDto.setId(crmLogInternalUpdateRequest.getId());
        crmLogEntityDto.setUuid(crmLogInternalUpdateRequest.getUuid());
        crmLogEntityDto.setCreatedDate(LocalDateTime.now());
        crmLogEntityDto.setLastModifiedDate(LocalDateTime.now());
        crmLogEntityDto.setTotalModified(0L);
        crmLogEntityDto.setIsTrashed(false);
        crmLogEntityDto.setTrashedDate(null);

        // Mock crmLogAccessorService.getCrmLogById() method.
        when(crmLogAccessorService.getCrmLogById(crmLogInternalUpdateRequest.getId()))
                .thenReturn(Optional.of(crmLogEntityDto));

        // Mock crmLogAccessorService.getCrmLogByUuid() method.
        when(crmLogAccessorService.getCrmLogByUuid(crmLogInternalUpdateRequest.getUuid()))
                .thenReturn(Optional.of(crmLogEntityDto));

    }

    @Test
    @DisplayName("Test all fields validation constraints with valid data")
    void testAllFieldsValidationConstraintsWithValidValues() {

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations is empty.
        assertTrue(violations.isEmpty());

    }

    @Test
    @DisplayName("Test id fields validation constraints with invalid value")
    void testIdFieldsValidationConstraintsWithInvalidValue() {

        // @NotNull validation constraint (null value).
        // Set id field to null value.
        crmLogInternalUpdateRequest.setId(null);

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains id field validation constraint.
        assertEquals("id", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains id field validation constraint message.
        assertEquals("ID is required cannot be null!", violations.iterator().next().getMessage());

        /// @Min validation constraint (value less than 100000000).
        // Set id field to value less than 100000000.
        crmLogInternalUpdateRequest.setId(99999999L);

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains id field validation constraint.
        assertEquals("id", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains id field validation constraint message.
        assertEquals("ID must be greater than or equal to 1000000000!", violations.iterator().next().getMessage());

        /// @IdExists validation constraint (value not exists in database).
        // Set id field to value not exists in database.
        crmLogInternalUpdateRequest.setId(1000000001L);

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains id field validation constraint.
        assertEquals("id", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains id field validation constraint message.
        assertEquals("ID does not exist in the system and cannot be updated!", violations.iterator().next().getMessage());

    }

    @Test
    @DisplayName("Test uuid fields validation constraints with invalid value")
    void testUuidFieldsValidationConstraintsWithInvalidValue() {

        // @NotNull validation constraint (null value).
        // Set uuid field to null value.
        crmLogInternalUpdateRequest.setUuid(null);

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains uuid field validation constraint.
        assertEquals("uuid", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains uuid field validation constraint message.
        assertEquals("UUID is required cannot be null!", violations.iterator().next().getMessage());

        /// @UuidExists validation constraint (value not exists in database).
        // Set uuid field to value not exists in database.
        crmLogInternalUpdateRequest.setUuid(UUID.randomUUID());

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains uuid field validation constraint.
        assertEquals("uuid", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains uuid field validation constraint message.
        assertEquals("UUID does not exist in the system and cannot be updated!", violations.iterator().next().getMessage());

    }

    @Test
    @DisplayName("Test message fields validation constraints with invalid value")
    void testMessageFieldsValidationConstraintsWithInvalidValue() {

        // @NotNull validation constraint (null value).
        // Set message field to null value.
        crmLogInternalUpdateRequest.setMessage(null);

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        log.info("violations: {}", violations);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains message field validation constraint.
        assertEquals("message", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains message field validation constraint message.
        assertEquals("Message is required and cannot be null!", violations.iterator().next().getMessage());

        /// @Length validation constraint (value length less than 10).
        // Set message field to value length less than 10.
        crmLogInternalUpdateRequest.setMessage(StringUtils.repeat("a", 9));

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains message field validation constraint.
        assertEquals("message", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains message field validation constraint message.
        assertEquals("Message must be between 10 and 1080 characters!", violations.iterator().next().getMessage());

        /// @Length validation constraint (value length greater than 1080).
        // Set message field to value length greater than 1080.
        crmLogInternalUpdateRequest.setMessage(StringUtils.repeat("a", 1081));

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains message field validation constraint.
        assertEquals("message", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains message field validation constraint message.
        assertEquals("Message must be between 10 and 1080 characters!", violations.iterator().next().getMessage());

    }

    @Test
    @DisplayName("Test logType fields validation constraints with invalid value")
    void testLogTypeFieldsValidationConstraintsWithInvalidValue() {

        // @NotNull validation constraint (null value).
        // Set logType field to null value.
        crmLogInternalUpdateRequest.setLogType(null);

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains logType field validation constraint.
        assertEquals("logType", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains logType field validation constraint message.
        assertEquals("Log type is required and cannot be null!", violations.iterator().next().getMessage());

        /// @ValueOfEnum validation constraint (value not exists in enumeration).
        // Set logType field to value not exists in enumeration.
        crmLogInternalUpdateRequest.setLogType("INVALID");

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains logType field validation constraint.
        assertEquals("logType", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains logType field validation constraint message.
        assertEquals("Log type must be one of the following: INFO, WARNING, ERROR, SUCCESS!", violations.iterator().next().getMessage());

    }

    @Test
    @DisplayName("Test userId fields validation constraints with invalid value")
    void testUserIdFieldsValidationConstraintsWithInvalidValue() {

        // @NotNull validation constraint (null value).
        // Set userId field to null value.
        crmLogInternalUpdateRequest.setUserId(null);

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains userId field validation constraint.
        assertEquals("userId", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains userId field validation constraint message.
        assertEquals("User ID is required and cannot be null!", violations.iterator().next().getMessage());

        /// @Min validation constraint (value less than 1000000000).
        // Set userId field to value less than 1000000000.
        crmLogInternalUpdateRequest.setUserId(100000000L - 1);

        // Validate crmLogInternalUpdateRequest class field and get violations.
        violations = validator.validate(crmLogInternalUpdateRequest);

        // Assert that violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains userId field validation constraint.
        assertEquals("userId", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains userId field validation constraint message.
        assertEquals("User ID must be greater than or equal to 1000000000!", violations.iterator().next().getMessage());

    }

    @AfterEach
    void tearDown() {

        // Reset class fields.
        crmLogInternalUpdateRequest = null;
        violations = null;

    }
}