package uk.co.speedypos.epp_log_service.controllers.crm_log.internal.mutator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import uk.co.speedypos.epp_log_service.consts.ApiPath;
import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.enums.LogType;
import uk.co.speedypos.epp_log_service.helpers.MapperHelper;
import uk.co.speedypos.epp_log_service.models.request.crm_log.internal.CrmLogInternalCreateRequest;
import uk.co.speedypos.epp_log_service.models.request.crm_log.internal.CrmLogInternalDeleteRequest;
import uk.co.speedypos.epp_log_service.models.request.crm_log.internal.CrmLogInternalUpdateRequest;
import uk.co.speedypos.epp_log_service.models.response.crm_log.internal.CrmLogInternalResponse;
import uk.co.speedypos.epp_log_service.services.crm_log.accessor.CrmLogAccessorService;
import uk.co.speedypos.epp_log_service.services.crm_log.mutator.CrmLogMutatorService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static uk.co.speedypos.epp_log_service.consts.Regex.LOCAL_DATE_TIME_RESPONSE_PATTERN;


/**
 * Test for {@link CrmLogInternalMutatorController} all methods.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@WebMvcTest(CrmLogInternalMutatorController.class)
@AutoConfigureMockMvc(addFilters = false)
@DisplayName("Test crm log internal mutator endpoints" + ApiPath.CRM_LOG_INTERNAL_REST_PATH)
class CrmLogInternalMutatorControllerTest {

    @MockBean
    private CrmLogAccessorService crmLogAccessorService;

    @MockBean
    private CrmLogMutatorService crmLogMutatorService;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private MockMvc mockMvc;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ObjectMapper objectMapper;

    private CrmLogEntityDto crmLogEntityDto;

    private CrmLogInternalResponse crmLogInternalResponse;

    @Test
    @DisplayName("Should create email address entity when POST request is sent with CrmLogInternalCreateRequest JSON object as request body and return CrmLogInternalResponse JSON object as response body with status code 201")
    void createCrmLog() throws Exception {

        // Create new CrmLogInternalCreateRequest object with valid data.
        var crmLogInternalCreateRequest = new CrmLogInternalCreateRequest();
        crmLogInternalCreateRequest.setMessage("Test crm log service");
        crmLogInternalCreateRequest.setLogType(LogType.getRandom().name());
        crmLogInternalCreateRequest.setUserId(1000000002L);

        // Initialize crmLogEntityDto field.
        // Map CrmLogInternalCreateRequest object to CrmLogEntityDto object.
        crmLogEntityDto = MapperHelper.map(crmLogInternalCreateRequest, CrmLogEntityDto.class);

        crmLogEntityDto.setId(1000000000L);
        crmLogEntityDto.setUuid(UUID.randomUUID());
        crmLogEntityDto.setCreatedDate(LocalDateTime.now());
        crmLogEntityDto.setLastModifiedDate(LocalDateTime.now());
        crmLogEntityDto.setTotalModified(1L);
        crmLogEntityDto.setIsTrashed(false);
        crmLogEntityDto.setTrashedDate(null);

        // Initialize crmLogInternalResponse field.
        // Map CrmLogEntityDto object to CrmLogInternalResponse object.
        crmLogInternalResponse = MapperHelper.map(crmLogEntityDto, CrmLogInternalResponse.class);


        // Mock the crmLogMutatorService.createCrmLog() method.
        when(crmLogMutatorService.createCrmLog(any(CrmLogEntityDto.class))).thenReturn(crmLogEntityDto);

        // Send POST request to create crm log.
        mockMvc.perform(post(ApiPath.CRM_LOG_INTERNAL_REST_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(crmLogInternalCreateRequest)))

                // Verify response content type is application/json.
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                // Verify the response status is CREATED.
                .andExpect(status().isCreated())

                // Verify the response body size.
                // Verify response body size.
                .andExpect(jsonPath("$.size()", is(10)))

                // Verify response body content.
                .andExpect(jsonPath("$.message", is(crmLogInternalResponse.getMessage())))
                .andExpect(jsonPath("$.log_type", is(crmLogInternalResponse.getLogType().name())))
                .andExpect(jsonPath("$.user_id", is(crmLogInternalResponse.getUserId().intValue())))

                .andExpect(jsonPath("$.id", is(crmLogInternalResponse.getId().intValue())))
                .andExpect(jsonPath("$.uuid", is(crmLogInternalResponse.getUuid().toString())))
                .andExpect(jsonPath("$.created_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getCreatedDate()))))
                .andExpect(jsonPath("$.last_modified_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getLastModifiedDate()))))
                .andExpect(jsonPath("$.total_modified", is(crmLogInternalResponse.getTotalModified().intValue())))
                .andExpect(jsonPath("$.is_trashed", is(crmLogInternalResponse.getIsTrashed())))
                .andExpect(jsonPath("$.trashed_date", is(crmLogInternalResponse.getTrashedDate())));

        // Verify the crmLogMutatorService.createCrmLog() method is called once.
        verify(crmLogMutatorService, times(1)).createCrmLog(any(CrmLogEntityDto.class));

    }

    @Test
    @DisplayName("Should update email address entity when PUT request is sent with CrmLogInternalUpdateRequest JSON object as request body and return CrmLogInternalResponse JSON object as response body with status code 200")
    void updateCrmLog() throws Exception {

        // Create new CrmLogInternalUpdateRequest object with valid data.
        var crmLogInternalUpdateRequest = new CrmLogInternalUpdateRequest();
        crmLogInternalUpdateRequest.setId(1000000000L);
        crmLogInternalUpdateRequest.setUuid(UUID.randomUUID());
        crmLogInternalUpdateRequest.setMessage("Test crm log service");
        crmLogInternalUpdateRequest.setLogType(LogType.getRandom().name());
        crmLogInternalUpdateRequest.setUserId(1000000002L);

        // Initialize crmLogEntityDto field.
        crmLogEntityDto = new CrmLogEntityDto();
        crmLogEntityDto.setMessage(crmLogInternalUpdateRequest.getMessage());
        crmLogEntityDto.setLogType(LogType.valueOf(crmLogInternalUpdateRequest.getLogType()));
        crmLogEntityDto.setUserId(crmLogInternalUpdateRequest.getUserId());
        crmLogEntityDto.setId(crmLogInternalUpdateRequest.getId());
        crmLogEntityDto.setUuid(crmLogInternalUpdateRequest.getUuid());
        crmLogEntityDto.setCreatedDate(LocalDateTime.now());
        crmLogEntityDto.setLastModifiedDate(LocalDateTime.now());
        crmLogEntityDto.setTotalModified(0L);
        crmLogEntityDto.setIsTrashed(true);
        crmLogEntityDto.setTrashedDate(LocalDateTime.now());

        // Initialize crmLogInternalResponse field.
        // Map CrmLogEntityDto object to CrmLogInternalResponse object.
        crmLogInternalResponse = MapperHelper.map(crmLogEntityDto, CrmLogInternalResponse.class);

        // Mock crmLogAccessorService.getCrmLogById() method.
        when(crmLogAccessorService.getCrmLogById(anyLong())).thenReturn(Optional.of(crmLogEntityDto));

        // Mock crmLogAccessorService.getCrmLogByUuid() method.
        when(crmLogAccessorService.getCrmLogByUuid(any(UUID.class))).thenReturn(Optional.of(crmLogEntityDto));

        // Mock the crmLogMutatorService.updateCrmLog() method.
        when(crmLogMutatorService.updateCrmLog(any(CrmLogEntityDto.class))).thenReturn(crmLogEntityDto);

        // Send PUT request to update crm log.
        mockMvc.perform(put(ApiPath.CRM_LOG_INTERNAL_REST_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(crmLogInternalUpdateRequest)))

                // Verify response content type is application/json.
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                // Verify the response status is OK.
                .andExpect(status().isOk())

                // Verify the response body size.
                // Verify response body size.
                .andExpect(jsonPath("$.size()", is(10)))

                // Verify response body content.
                .andExpect(jsonPath("$.message", is(crmLogInternalResponse.getMessage())))
                .andExpect(jsonPath("$.log_type", is(crmLogInternalResponse.getLogType().name())))
                .andExpect(jsonPath("$.user_id", is(crmLogInternalResponse.getUserId().intValue())))

                .andExpect(jsonPath("$.id", is(crmLogInternalResponse.getId().intValue())))
                .andExpect(jsonPath("$.uuid", is(crmLogInternalResponse.getUuid().toString())))
                .andExpect(jsonPath("$.created_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getCreatedDate()))))
                .andExpect(jsonPath("$.last_modified_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getLastModifiedDate()))))
                .andExpect(jsonPath("$.total_modified", is(crmLogInternalResponse.getTotalModified().intValue())))
                .andExpect(jsonPath("$.is_trashed", is(crmLogInternalResponse.getIsTrashed())))
                .andExpect(jsonPath("$.trashed_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getTrashedDate()))));

        // Verify the crmLogMutatorService.updateCrmLog() method is called once.
        verify(crmLogMutatorService, times(1)).updateCrmLog(any(CrmLogEntityDto.class));
    }

    @Test
    @DisplayName("Should delete email address entity when DELETE request is sent with CrmLogInternalDeleteRequest JSON object as request body and return CrmLogInternalResponse JSON object as response body with status code 200")
    void deleteCrmLog() throws Exception {

        // Create new CrmLogInternalDeleteRequest object with valid data.
        var crmLogInternalDeleteRequest = new CrmLogInternalDeleteRequest();
        crmLogInternalDeleteRequest.setId(1000000000L);
        crmLogInternalDeleteRequest.setUuid(UUID.randomUUID());

        // Initialize crmLogEntityDto field.
        // Map CrmLogInternalDeleteRequest object to CrmLogEntityDto object.
        crmLogEntityDto = MapperHelper.map(crmLogInternalDeleteRequest, CrmLogEntityDto.class);

        crmLogEntityDto.setCreatedDate(LocalDateTime.now());
        crmLogEntityDto.setLastModifiedDate(LocalDateTime.now());
        crmLogEntityDto.setTotalModified(1L);
        crmLogEntityDto.setIsTrashed(true);
        crmLogEntityDto.setTrashedDate(LocalDateTime.now());

        crmLogEntityDto.setMessage("Test crm log service");
        crmLogEntityDto.setLogType(LogType.getRandom());
        crmLogEntityDto.setUserId(1000000002L);

        // Initialize crmLogInternalResponse field.
        // Map CrmLogEntityDto object to CrmLogInternalResponse object.
        crmLogInternalResponse = MapperHelper.map(crmLogEntityDto, CrmLogInternalResponse.class);

        // Mock the crmLogMutatorService.deleteCrmLog() method.
        when(crmLogMutatorService.deleteCrmLog(any(CrmLogEntityDto.class))).thenReturn(crmLogEntityDto);

        // Send DELETE request to delete crm log.
        mockMvc.perform(delete(ApiPath.CRM_LOG_INTERNAL_REST_PATH).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(crmLogInternalDeleteRequest)))

                // Verify response content type is application/json.
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                // Verify the response status is OK.
                .andExpect(status().isOk())

                // Verify the response body size.
                // Verify response body size.
                .andExpect(jsonPath("$.size()", is(10)))

                // Verify response body content.
                .andExpect(jsonPath("$.message", is(crmLogInternalResponse.getMessage())))
                .andExpect(jsonPath("$.log_type", is(crmLogInternalResponse.getLogType().name())))
                .andExpect(jsonPath("$.user_id", is(crmLogInternalResponse.getUserId().intValue())))

                .andExpect(jsonPath("$.id", is(crmLogInternalResponse.getId().intValue())))
                .andExpect(jsonPath("$.uuid", is(crmLogInternalResponse.getUuid().toString())))
                .andExpect(jsonPath("$.created_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getCreatedDate()))))
                .andExpect(jsonPath("$.last_modified_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getLastModifiedDate()))))
                .andExpect(jsonPath("$.total_modified", is(crmLogInternalResponse.getTotalModified().intValue())))
                .andExpect(jsonPath("$.is_trashed", is(crmLogInternalResponse.getIsTrashed())))
                .andExpect(jsonPath("$.trashed_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getTrashedDate()))));
    }

    @AfterEach
    void tearDown() {

        // Reset fields.
        crmLogEntityDto = null;
        crmLogInternalResponse = null;

    }
}