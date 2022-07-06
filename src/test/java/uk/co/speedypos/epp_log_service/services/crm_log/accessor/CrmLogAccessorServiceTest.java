package uk.co.speedypos.epp_log_service.services.crm_log.accessor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.entities.CrmLogEntity;
import uk.co.speedypos.epp_log_service.enums.LogType;
import uk.co.speedypos.epp_log_service.helpers.MapperHelper;
import uk.co.speedypos.epp_log_service.repositories.CrmLogEntityRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Test for crm log accessor service all business logic.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@SpringBootTest(classes = CrmLogAccessorService.class)
@DisplayName("Test crm log accessor service business logic")
class CrmLogAccessorServiceTest {

    @MockBean
    private CrmLogEntityRepository crmLogEntityRepository;

    private CrmLogAccessorService crmLogAccessorService;

    private CrmLogEntity crmLogEntity;

    private CrmLogEntityDto crmLogEntityDto;

    @BeforeEach
    void setUp() {

        // Init crmLogEntity field.
        crmLogEntity = new CrmLogEntity();

        crmLogEntity.setMessage("Test log message");
        crmLogEntity.setLogType(LogType.getRandom());
        crmLogEntity.setUserId(1L);

        crmLogEntity.setId(1000000000L);
        crmLogEntity.setUuid(UUID.randomUUID());
        crmLogEntity.setCreatedDate(LocalDateTime.now());
        crmLogEntity.setLastModifiedDate(LocalDateTime.now());
        crmLogEntity.setTotalModified(1L);
        crmLogEntity.setIsTrashed(false);
        crmLogEntity.setTrashedDate(null);

        // Initialize crmLogEntityDto field.
        // Map crmLogEntity object to CrmLogEntityDto object.
        crmLogEntityDto = MapperHelper.map(crmLogEntity, CrmLogEntityDto.class);

        // Initialize crmLogAccessorService field.
        crmLogAccessorService = new CrmLogAccessorServiceImpl(crmLogEntityRepository);

    }

    @Test
    @DisplayName("Should return list of CrmLogEntityDto objects when getAllCrmLogs() is called")
    void getCrmLogs() {

        // Mock crmLogEntityRepository.findAll() method to return list of CrmLogEntity objects.
        when(crmLogEntityRepository.findAll()).thenReturn(List.of(crmLogEntity));

        // Call getCrmLogs() method and assert that it returns list of CrmLogEntityDto objects.
        var crmLogEntityDtoList = crmLogAccessorService.getCrmLogs();

        // Assert that crmLogEntityDtoList objects contains only one element.
        assertEquals(1, crmLogEntityDtoList.size());

        // Assert that all fields is equal to the fields of crmLogEntityDto object.
        assertEquals(crmLogEntityDto.getMessage(), crmLogEntityDtoList.get(0).getMessage());
        assertEquals(crmLogEntityDto.getLogType(), crmLogEntityDtoList.get(0).getLogType());

        assertEquals(crmLogEntityDto.getId(), crmLogEntityDtoList.get(0).getId());
        assertEquals(crmLogEntityDto.getUuid(), crmLogEntityDtoList.get(0).getUuid());
        assertEquals(crmLogEntityDto.getCreatedDate(), crmLogEntityDtoList.get(0).getCreatedDate());
        assertEquals(crmLogEntityDto.getLastModifiedDate(), crmLogEntityDtoList.get(0).getLastModifiedDate());
        assertEquals(crmLogEntityDto.getTotalModified(), crmLogEntityDtoList.get(0).getTotalModified());
        assertEquals(crmLogEntityDto.getIsTrashed(), crmLogEntityDtoList.get(0).getIsTrashed());
        assertEquals(crmLogEntityDto.getTrashedDate(), crmLogEntityDtoList.get(0).getTrashedDate());

        // Verify that crmLogEntityRepository.findAll() method was called once.
        verify(crmLogEntityRepository, times(1)).findAll();

    }

    @Test
    @DisplayName("Should return list of CrmLogEntityDto objects when getCrmLogsByUserId() is called")
    void getCrmLogsByUserId() {

        // Mock crmLogEntityRepository.findAllByUserId() method to return list of CrmLogEntity objects.
        when(crmLogEntityRepository.findAllByUserId(anyLong())).thenReturn(List.of(crmLogEntity));

        // Call getCrmLogsByUserId() method and assert that it returns list of CrmLogEntityDto objects.
        var returnedCrmLogEntityDtoList = crmLogAccessorService.getCrmLogsByUserId(1L);

        // Assert that returnedCrmLogEntityDtoList objects contains only one element.
        assertEquals(1, returnedCrmLogEntityDtoList.size());

        // Assert that equals() method returns true.
        assertEquals(crmLogEntityDto.getMessage(), returnedCrmLogEntityDtoList.get(0).getMessage());
        assertEquals(crmLogEntityDto.getLogType(), returnedCrmLogEntityDtoList.get(0).getLogType());

        assertEquals(crmLogEntityDto.getId(), returnedCrmLogEntityDtoList.get(0).getId());
        assertEquals(crmLogEntityDto.getUuid(), returnedCrmLogEntityDtoList.get(0).getUuid());
        assertEquals(crmLogEntityDto.getCreatedDate(), returnedCrmLogEntityDtoList.get(0).getCreatedDate());
        assertEquals(crmLogEntityDto.getLastModifiedDate(), returnedCrmLogEntityDtoList.get(0).getLastModifiedDate());
        assertEquals(crmLogEntityDto.getTotalModified(), returnedCrmLogEntityDtoList.get(0).getTotalModified());
        assertEquals(crmLogEntityDto.getIsTrashed(), returnedCrmLogEntityDtoList.get(0).getIsTrashed());
        assertEquals(crmLogEntityDto.getTrashedDate(), returnedCrmLogEntityDtoList.get(0).getTrashedDate());

    }

    @Test
    @DisplayName("Should return CrmLogEntityDto object when getCrmLogById() is called")
    void getCrmLogById() {

        // Mock crmLogEntityRepository.findById() method to return CrmLogEntity object.
        when(crmLogEntityRepository.findById(anyLong())).thenReturn(Optional.of(crmLogEntity));

        // Call getCrmLogById() method and assert that it returns CrmLogEntityDto object.
        var foundedCrmLogEntityDto = crmLogAccessorService.getCrmLogById(1L);

        // Assert that foundedCrmLogEntityDto is present.
        assertTrue(foundedCrmLogEntityDto.isPresent());

        foundedCrmLogEntityDto.ifPresent(entityDto -> {

            // Assert that all fields is equal to the fields of crmLogEntityDto object.
            assertEquals(crmLogEntityDto.getMessage(), entityDto.getMessage());
            assertEquals(crmLogEntityDto.getLogType(), entityDto.getLogType());

            assertEquals(crmLogEntityDto.getId(), entityDto.getId());
            assertEquals(crmLogEntityDto.getUuid(), entityDto.getUuid());
            assertEquals(crmLogEntityDto.getCreatedDate(), entityDto.getCreatedDate());
            assertEquals(crmLogEntityDto.getLastModifiedDate(), entityDto.getLastModifiedDate());
            assertEquals(crmLogEntityDto.getTotalModified(), entityDto.getTotalModified());
            assertEquals(crmLogEntityDto.getIsTrashed(), entityDto.getIsTrashed());
            assertEquals(crmLogEntityDto.getTrashedDate(), entityDto.getTrashedDate());

        });
    }

    @Test
    @DisplayName("Should return CrmLogEntityDto object when getCrmLogByUuid() is called")
    void getCrmLogByUuid() {

        // Mock crmLogEntityRepository.findByUuid() method to return CrmLogEntity object.
        when(crmLogEntityRepository.findByUuid(any(UUID.class))).thenReturn(Optional.of(crmLogEntity));

        // Call getCrmLogByUuid() method and assert that it returns CrmLogEntityDto object.
        var foundedCrmLogEntityDto = crmLogAccessorService.getCrmLogByUuid(UUID.randomUUID());

        // Assert that foundedCrmLogEntityDto is present.
        assertTrue(foundedCrmLogEntityDto.isPresent());

        foundedCrmLogEntityDto.ifPresent(entityDto -> {

            // Assert that all fields is equal to the fields of crmLogEntityDto object.
            assertEquals(crmLogEntityDto.getMessage(), entityDto.getMessage());
            assertEquals(crmLogEntityDto.getLogType(), entityDto.getLogType());

            assertEquals(crmLogEntityDto.getId(), entityDto.getId());
            assertEquals(crmLogEntityDto.getUuid(), entityDto.getUuid());
            assertEquals(crmLogEntityDto.getCreatedDate(), entityDto.getCreatedDate());
            assertEquals(crmLogEntityDto.getLastModifiedDate(), entityDto.getLastModifiedDate());
            assertEquals(crmLogEntityDto.getTotalModified(), entityDto.getTotalModified());
            assertEquals(crmLogEntityDto.getIsTrashed(), entityDto.getIsTrashed());
            assertEquals(crmLogEntityDto.getTrashedDate(), entityDto.getTrashedDate());

        });
    }

    @AfterEach
    void tearDown() {

        // Reset mock objects.
        reset(crmLogEntityRepository);

        // Reset fields.
        crmLogEntityDto = null;
        crmLogEntity = null;
        crmLogAccessorService = null;

    }
}