package uk.co.speedypos.epp_log_service.models.request.crm_log.internal;

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
 * Test class for {@link CrmLogInternalDeleteRequest} all fields validation constraints.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@WebMvcTest(CrmLogInternalDeleteRequest.class)
@AutoConfigureMockMvc(addFilters = false)
@DisplayName("Tests for CrmLogInternalDeleteRequest model all fields validation constraints")
class CrmLogInternalDeleteRequestTest {

    @MockBean
    private CrmLogAccessorService crmLogAccessorService;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private Validator validator;

    private CrmLogInternalDeleteRequest crmLogInternalDeleteRequest;

    private Set<ConstraintViolation<CrmLogInternalDeleteRequest>> violations;

    @BeforeEach
    void setUp() {

        // Initialize crmLogInternalDeleteRequest class field.
        crmLogInternalDeleteRequest = new CrmLogInternalDeleteRequest();
        crmLogInternalDeleteRequest.setId(1000000000L);
        crmLogInternalDeleteRequest.setUuid(UUID.randomUUID());

        // Initialize crmLogEntityDto class field.
        var crmLogEntityDto = new CrmLogEntityDto();
        crmLogEntityDto.setMessage("Test crm log message");
        crmLogEntityDto.setLogType(LogType.getRandom());
        crmLogEntityDto.setUserId(1000000001L);
        crmLogEntityDto.setId(crmLogInternalDeleteRequest.getId());
        crmLogEntityDto.setUuid(crmLogInternalDeleteRequest.getUuid());
        crmLogEntityDto.setCreatedDate(LocalDateTime.now());
        crmLogEntityDto.setLastModifiedDate(LocalDateTime.now());
        crmLogEntityDto.setTotalModified(1L);
        crmLogEntityDto.setIsTrashed(true);
        crmLogEntityDto.setTrashedDate(LocalDateTime.now());

        // Mock crmLogAccessorService.getCrmLogById() method.
        when(crmLogAccessorService.getCrmLogById(crmLogInternalDeleteRequest.getId()))
                .thenReturn(Optional.of(crmLogEntityDto));

        // Mock crmLogAccessorService.getCrmLogByUuid() method.
        when(crmLogAccessorService.getCrmLogByUuid(crmLogInternalDeleteRequest.getUuid()))
                .thenReturn(Optional.of(crmLogEntityDto));

    }

    @Test
    @DisplayName("Test all fields validation constraints with valid values")
    void testAllFieldsValidationConstraintsWithValidValues() {

        // Validate crmLogInternalDeleteRequest class field and get violations.
        violations = validator.validate(crmLogInternalDeleteRequest);

        // Assert violations is empty.
        assertTrue(violations.isEmpty());

    }

    @Test
    @DisplayName("Test id field validation constraints with invalid values")
    void testIdFieldValidationConstraintsWithInvalidValues() {

        // @NotNull validation constraint.
        // Set invalid id value.
        crmLogInternalDeleteRequest.setId(null);

        // Validate crmLogInternalDeleteRequest class field and get violations.
        violations = validator.validate(crmLogInternalDeleteRequest);

        // Assert violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains id field validation constraint.
        assertEquals("id", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains id field validation constraint message.
        assertEquals("ID is required and cannot be null!", violations.iterator().next().getMessage());

        /// @IdExists validation constraint.
        // Set invalid id value.
        crmLogInternalDeleteRequest.setId(1000000002L);

        // Validate crmLogInternalDeleteRequest class field and get violations.
        violations = validator.validate(crmLogInternalDeleteRequest);

        // Assert violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains id field validation constraint.
        assertEquals("id", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains id field validation constraint message.
        assertEquals("ID does not exist in the system and cannot be deleted!", violations.iterator().next().getMessage());

    }

    @Test
    @DisplayName("Test uuid field validation constraints with invalid values")
    void testUuidFieldValidationConstraintsWithInvalidValues() {

        // @NotNull validation constraint.
        // Set invalid uuid value.
        crmLogInternalDeleteRequest.setUuid(null);

        // Validate crmLogInternalDeleteRequest class field and get violations.
        violations = validator.validate(crmLogInternalDeleteRequest);

        // Assert violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains uuid field validation constraint.
        assertEquals("uuid", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains uuid field validation constraint message.
        assertEquals("UUID is required and cannot be null!", violations.iterator().next().getMessage());

        /// @UuidExists validation constraint.
        // Set invalid uuid value.
        crmLogInternalDeleteRequest.setUuid(UUID.randomUUID());

        // Validate crmLogInternalDeleteRequest class field and get violations.
        violations = validator.validate(crmLogInternalDeleteRequest);

        // Assert violations size is 1.
        assertEquals(1, violations.size());

        // Assert that violations contains uuid field validation constraint.
        assertEquals("uuid", violations.iterator().next().getPropertyPath().toString());

        // Assert that violations contains uuid field validation constraint message.
        assertEquals("UUID does not exist in the system and cannot be deleted!", violations.iterator().next().getMessage());

    }

    @AfterEach
    void tearDown() {

        // Reset class fields.
        crmLogInternalDeleteRequest = null;
        violations = null;

    }
}