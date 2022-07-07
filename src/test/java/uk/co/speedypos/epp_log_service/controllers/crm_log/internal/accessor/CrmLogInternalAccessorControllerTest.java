package uk.co.speedypos.epp_log_service.controllers.crm_log.internal.accessor;


import org.junit.jupiter.api.BeforeEach;
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
import uk.co.speedypos.epp_log_service.models.response.crm_log.internal.CrmLogInternalResponse;
import uk.co.speedypos.epp_log_service.services.crm_log.accessor.CrmLogAccessorService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static uk.co.speedypos.epp_log_service.consts.Regex.LOCAL_DATE_TIME_RESPONSE_PATTERN;

/**
 * Test class for {@link CrmLogInternalAccessorControllerImpl} all methods.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@WebMvcTest(CrmLogInternalAccessorController.class)
@AutoConfigureMockMvc(addFilters = false)
@DisplayName("Test crm log internal accessor endpoints" + ApiPath.CRM_LOG_INTERNAL_REST_PATH)
class CrmLogInternalAccessorControllerTest {

    @MockBean
    private CrmLogAccessorService crmLogAccessorService;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private MockMvc mockMvc;

    private CrmLogEntityDto crmLogEntityDto;

    private CrmLogInternalResponse crmLogInternalResponse;

    @BeforeEach
    void setUp() {

        // Initialize crmLogEntityDto field.
        crmLogEntityDto = new CrmLogEntityDto();
        crmLogEntityDto.setMessage("Test log message");
        crmLogEntityDto.setLogType(LogType.getRandom());
        crmLogEntityDto.setUserId(1L);

        crmLogEntityDto.setId(1000000000L);
        crmLogEntityDto.setUuid(UUID.randomUUID());
        crmLogEntityDto.setCreatedDate(LocalDateTime.now());
        crmLogEntityDto.setLastModifiedDate(LocalDateTime.now());
        crmLogEntityDto.setTotalModified(1L);
        crmLogEntityDto.setIsTrashed(false);
        crmLogEntityDto.setTrashedDate(null);

        // Initialize crmLogInternalResponse field.
        // Map crmLogEntityDto to CrmLogInternalResponse.
        crmLogInternalResponse = MapperHelper.map(crmLogEntityDto, CrmLogInternalResponse.class);

    }

    @Test
    @DisplayName("Should return list of CrmLogInternalResponse response JSON body with status code 200 when GET request is sent")
    void getCrmLogs() throws Exception {

        // Mock crmLogAccessorService.getCrmLogs() method to return list of CrmLogEntityDto.
        when(crmLogAccessorService.getCrmLogs()).thenReturn(List.of(crmLogEntityDto));

        // Send GET request.
        mockMvc.perform(get(ApiPath.CRM_LOG_INTERNAL_REST_PATH).accept(MediaType.APPLICATION_JSON))

                // Verify response status is ok.
                .andExpect(status().isOk())

                // Verify response content type is application/json.
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                // Verify response body sizes
                .andExpect(jsonPath("$.size()", is(1)))
                .andExpect(jsonPath("$[0].size()", is(10)))

                // Verify response body content.
                .andExpect(jsonPath("$[0].message", is(crmLogInternalResponse.getMessage())))
                .andExpect(jsonPath("$[0].log_type", is(crmLogInternalResponse.getLogType().name())))
                .andExpect(jsonPath("$[0].user_id", is(crmLogInternalResponse.getUserId().intValue())))

                .andExpect(jsonPath("$[0].id", is(crmLogInternalResponse.getId().intValue())))
                .andExpect(jsonPath("$[0].uuid", is(crmLogInternalResponse.getUuid().toString())))
                .andExpect(jsonPath("$[0].created_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getCreatedDate()))))
                .andExpect(jsonPath("$[0].last_modified_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getLastModifiedDate()))))
                .andExpect(jsonPath("$[0].total_modified", is(crmLogInternalResponse.getTotalModified().intValue())))
                .andExpect(jsonPath("$[0].is_trashed", is(crmLogInternalResponse.getIsTrashed())))
                .andExpect(jsonPath("$[0].trashed_date", is(crmLogInternalResponse.getTrashedDate())));

        // Verify the crmLogAccessorService.getCrmLogs() method is called once.
        verify(crmLogAccessorService, times(1)).getCrmLogs();

    }

    @Test
    @DisplayName("Should return list of CrmLogInternalResponse response JSON body with status code 200 when GET request is sent to /user/{userId}")
    void getCrmLogsByUserId() throws Exception {

        // Mock crmLogAccessorService.getCrmLogs(Long userId) method to return list of CrmLogEntityDto.
        when(crmLogAccessorService.getCrmLogsByUserId(anyLong())).thenReturn(List.of(crmLogEntityDto));

        // Send GET request.
        mockMvc.perform(get(ApiPath.CRM_LOG_INTERNAL_REST_PATH + "/user/1").accept(MediaType.APPLICATION_JSON))

                // Verify response status is ok.
                .andExpect(status().isOk())

                // Verify response content type is application/json.
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                // Verify response body sizes
                .andExpect(jsonPath("$.size()", is(1)))
                .andExpect(jsonPath("$[0].size()", is(10)))

                // Verify response body content.
                .andExpect(jsonPath("$[0].message", is(crmLogInternalResponse.getMessage())))
                .andExpect(jsonPath("$[0].log_type", is(crmLogInternalResponse.getLogType().name())))
                .andExpect(jsonPath("$[0].user_id", is(crmLogInternalResponse.getUserId().intValue())))

                .andExpect(jsonPath("$[0].id", is(crmLogInternalResponse.getId().intValue())))
                .andExpect(jsonPath("$[0].uuid", is(crmLogInternalResponse.getUuid().toString())))
                .andExpect(jsonPath("$[0].created_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getCreatedDate()))))
                .andExpect(jsonPath("$[0].last_modified_date", is(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_RESPONSE_PATTERN).format(crmLogInternalResponse.getLastModifiedDate()))))
                .andExpect(jsonPath("$[0].total_modified", is(crmLogInternalResponse.getTotalModified().intValue())))
                .andExpect(jsonPath("$[0].is_trashed", is(crmLogInternalResponse.getIsTrashed())))
                .andExpect(jsonPath("$[0].trashed_date", is(crmLogInternalResponse.getTrashedDate())));

        // Verify the crmLogAccessorService.getCrmLogs(Long userId) method is called once.
        verify(crmLogAccessorService, times(1)).getCrmLogsByUserId(anyLong());

    }

    @Test
    @DisplayName("Should return CrmLogInternalResponse response JSON body with status code 200 when GET request is sent")
    void getCrmLogById() throws Exception {

        // Mock crmLogAccessorService.getCrmLog(Long id) method to return CrmLogEntityDto.
        when(crmLogAccessorService.getCrmLogById(anyLong())).thenReturn(Optional.of(crmLogEntityDto));

        // Send GET request.
        mockMvc.perform(get(ApiPath.CRM_LOG_INTERNAL_REST_PATH + "/{id}", 1L).accept(MediaType.APPLICATION_JSON))

                // Verify response status is ok.
                .andExpect(status().isOk())

                // Verify response content type is application/json.
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

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

        // Verify the crmLogAccessorService.getCrmLog(Long id) method is called once.
        verify(crmLogAccessorService, times(1)).getCrmLogById(anyLong());

    }
}