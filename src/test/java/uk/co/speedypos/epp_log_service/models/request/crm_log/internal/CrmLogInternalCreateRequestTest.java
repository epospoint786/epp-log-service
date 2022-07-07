package uk.co.speedypos.epp_log_service.models.request.crm_log.internal;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import uk.co.speedypos.epp_log_service.enums.LogType;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link CrmLogInternalCreateRequest} all fields validation constraints.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@WebMvcTest(CrmLogInternalCreateRequest.class)
@AutoConfigureMockMvc(addFilters = false)
@DisplayName("Tests for CrmLogInternalCreateRequest model all fields validation constraints")
class CrmLogInternalCreateRequestTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private Validator validator;

    private CrmLogInternalCreateRequest crmLogInternalCreateRequest;

    private Set<ConstraintViolation<CrmLogInternalCreateRequest>> violations;

    @BeforeEach
    void setUp() {

        // Initialize crmLogInternalCreateRequest class field.
        crmLogInternalCreateRequest = new CrmLogInternalCreateRequest();
        crmLogInternalCreateRequest.setMessage("Test crm log message");
        crmLogInternalCreateRequest.setLogType(LogType.getRandom().name());
        crmLogInternalCreateRequest.setUserId(100000000L);
    }

    @Test
    @DisplayName("Test all fields validation constraints with valid data")
    void testAllFieldsValidationConstraintsWithValidValues() {

        // Validate crmLogInternalCreateRequest class field and get violations.
        violations = validator.validate(crmLogInternalCreateRequest);

        // Assert that violations is empty.
        assertTrue(violations.isEmpty());

    }

    @Test
    @DisplayName("Test message fields validation constraints with invalid value")
    void testMessageFieldsValidationConstraintsWithInvalidValue() {

        // @NotEmpty validation constraint (null value).
        // Set message field to null value.
        crmLogInternalCreateRequest.setMessage(null);

        // Validate crmLogInternalCreateRequest class field and get violations.
        violations = validator.validate(crmLogInternalCreateRequest);

        // Assert that violations contains message field validation constraint.
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("message")));

        // Assert that violations contains message field validation message.
        assertTrue(violations.stream().anyMatch(violation -> violation.getMessage().equals("Message is required and cannot be empty or null!")));


        // @NotEmpty validation constraint (empty value).
        // Set message field to empty value.
        crmLogInternalCreateRequest.setMessage("");

        // Validate crmLogInternalCreateRequest class field and get violations.
        violations = validator.validate(crmLogInternalCreateRequest);

        // Assert that violations contains message field validation constraint.
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("message")));

        // Assert that violations contains message field validation message.
        assertTrue(violations.stream().anyMatch(violation -> violation.getMessage().equals("Message is required and cannot be empty or null!")));

        /// @Length validation constraint (max = 1080).
        // Set message field to value with length > 1080.
        crmLogInternalCreateRequest.setMessage(StringUtils.repeat("a", 1081));

        // Validate crmLogInternalCreateRequest class field and get violations.
        violations = validator.validate(crmLogInternalCreateRequest);

        // Assert that violations contains message field validation constraint.
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("message")));

        // Assert that violations contains message field validation constraint message.
        assertTrue(violations.stream().anyMatch(violation -> violation.getMessage().equals("Message must be less than or equal to 1080 characters!")));

    }

    @Test
    @DisplayName("Test logType fields validation constraints with invalid value")
    void testLogTypeFieldsValidationConstraintsWithInvalidValue() {

        // @NotNull validation constraint.
        // Set logType field to null value.
        crmLogInternalCreateRequest.setLogType(null);

        // Validate crmLogInternalCreateRequest class field and get violations.
        violations = validator.validate(crmLogInternalCreateRequest);

        // Assert that violations contains logType field validation constraint.
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("logType")));

        // Assert that violations contains logType field validation constraint message.
        assertTrue(violations.stream().anyMatch(violation -> violation.getMessage().equals("Log type is required and cannot be null!")));

        /// @ValueOfEnum validation constraint.
        // Set logType field to invalid value.
        crmLogInternalCreateRequest.setLogType("INVALID_LOG_TYPE");

        // Validate crmLogInternalCreateRequest class field and get violations.
        violations = validator.validate(crmLogInternalCreateRequest);

        // Assert that violations contains logType field validation constraint.
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("logType")));

        // Assert that violations contains logType field validation constraint message.
        assertTrue(violations.stream().anyMatch(violation -> violation.getMessage().equals("Log type must be one of the following: INFO, WARNING, ERROR, SUCCESS!")));

    }

    @Test
    @DisplayName("Test userId fields validation constraints with invalid value")
    void testUserIdFieldsValidationConstraintsWithInvalidValue() {

        // @NotNull validation constraint.
        // Set userId field to null value.
        crmLogInternalCreateRequest.setUserId(null);

        // Validate crmLogInternalCreateRequest class field and get violations.
        violations = validator.validate(crmLogInternalCreateRequest);

        // Assert that violations contains userId field validation constraint.
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("userId")));

        // Assert that violations contains userId field validation constraint message.
        assertTrue(violations.stream().anyMatch(violation -> violation.getMessage().equals("User id is required and cannot be null!")));

        /// @Min validation constraint (value = 100000000).
        // Set userId field to value less than 100000000.
        crmLogInternalCreateRequest.setUserId(100000000L - 1);

        // Validate crmLogInternalCreateRequest class field and get violations.
        violations = validator.validate(crmLogInternalCreateRequest);

        // Assert that violations contains userId field validation constraint.
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("userId")));

        // Assert that violations contains userId field validation constraint message.
        assertTrue(violations.stream().anyMatch(violation -> violation.getMessage().equals("User id must be greater than or equal to 1000000000!")));

    }

    @AfterEach
    void tearDown() {

        // Reset class field.
        crmLogInternalCreateRequest = null;
        violations = null;

    }
}