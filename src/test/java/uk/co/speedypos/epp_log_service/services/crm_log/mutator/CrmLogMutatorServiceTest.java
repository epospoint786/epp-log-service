package uk.co.speedypos.epp_log_service.services.crm_log.mutator;

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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Test for crm log mutator service all business logic.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@SpringBootTest(classes = CrmLogMutatorService.class)
@DisplayName("Test crm log mutator service business logic")
class CrmLogMutatorServiceTest {

    @MockBean
    private CrmLogEntityRepository crmLogEntityRepository;

    private CrmLogMutatorService crmLogMutatorService;

    private CrmLogEntityDto crmLogEntityDto;

    private CrmLogEntity crmLogEntity;

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

        // Initialize crmLogMutatorService field.
        crmLogMutatorService = new CrmLogMutatorServiceImpl(crmLogEntityRepository);

    }

    @Test
    @DisplayName("Should create crm log entity and return CrmLogEntityDto object when createCrmLog() is called")
    void createCrmLog() {

        // Mock crmLogEntityRepository.save() method to return crmLogEntity.
        when(crmLogEntityRepository.save(any(CrmLogEntity.class))).thenReturn(crmLogEntity);

        // Call createCrmLogEntity() method from crmLogMutatorService.
        var createdCrmLogEntityDto = crmLogMutatorService.createCrmLog(crmLogEntityDto);

        // Assert createdCrmLogEntityDto object is not null.
        assertNotNull(createdCrmLogEntityDto);

        // Assert createdCrmLogEntityDto object with crmLogEntityDto field object.
        assertEquals(crmLogEntityDto.getMessage(), createdCrmLogEntityDto.getMessage());
        assertEquals(crmLogEntityDto.getLogType(), createdCrmLogEntityDto.getLogType());

        assertEquals(crmLogEntityDto.getId(), createdCrmLogEntityDto.getId());
        assertEquals(crmLogEntityDto.getUuid(), createdCrmLogEntityDto.getUuid());
        assertEquals(crmLogEntityDto.getCreatedDate(), createdCrmLogEntityDto.getCreatedDate());
        assertEquals(crmLogEntityDto.getLastModifiedDate(), createdCrmLogEntityDto.getLastModifiedDate());
        assertEquals(crmLogEntityDto.getTotalModified(), createdCrmLogEntityDto.getTotalModified());
        assertEquals(crmLogEntityDto.getIsTrashed(), createdCrmLogEntityDto.getIsTrashed());
        assertEquals(crmLogEntityDto.getTrashedDate(), createdCrmLogEntityDto.getTrashedDate());

        // Verify crmLogEntityRepository.save() method is called once.
        verify(crmLogEntityRepository, times(1)).save(any(CrmLogEntity.class));

    }

    @Test
    @DisplayName("Should update crm log entity and return CrmLogEntityDto object when updateCrmLog() is called")
    void updateCrmLog() {

        // Mock crmLogEntityRepository.save() method to return crmLogEntity.
        when(crmLogEntityRepository.save(any(CrmLogEntity.class))).thenReturn(crmLogEntity);

        // Mock crmLogEntityRepository.findByIdAndUuid() method to return crmLogEntity.
        when(crmLogEntityRepository.findByIdAndUuid(anyLong(), any(UUID.class))).thenReturn(crmLogEntity);

        // Call updateCrmLogEntity() method from crmLogMutatorService.
        var updatedCrmLogEntityDto = crmLogMutatorService.updateCrmLog(crmLogEntityDto);

        // Assert updatedCrmLogEntityDto object is not null.
        assertNotNull(updatedCrmLogEntityDto);

        // Assert updatedCrmLogEntityDto object with crmLogEntityDto field object.
        assertEquals(crmLogEntityDto.getMessage(), updatedCrmLogEntityDto.getMessage());
        assertEquals(crmLogEntityDto.getLogType(), updatedCrmLogEntityDto.getLogType());

        assertEquals(crmLogEntityDto.getId(), updatedCrmLogEntityDto.getId());
        assertEquals(crmLogEntityDto.getUuid(), updatedCrmLogEntityDto.getUuid());
        assertEquals(crmLogEntityDto.getCreatedDate(), updatedCrmLogEntityDto.getCreatedDate());
        assertEquals(crmLogEntityDto.getLastModifiedDate(), updatedCrmLogEntityDto.getLastModifiedDate());
        assertEquals(crmLogEntityDto.getTotalModified(), updatedCrmLogEntityDto.getTotalModified());
        assertEquals(crmLogEntityDto.getIsTrashed(), updatedCrmLogEntityDto.getIsTrashed());
        assertEquals(crmLogEntityDto.getTrashedDate(), updatedCrmLogEntityDto.getTrashedDate());

        // Verify crmLogEntityRepository.save() method is called once.
        verify(crmLogEntityRepository, times(1)).save(any(CrmLogEntity.class));
    }

    @Test
    @DisplayName("Should delete crm log entity and return CrmLogEntityDto object when deleteCrmLog() is called")
    void deleteCrmLog() {

        // Mock crmLogEntityRepository.findByIdAndUuid() method to return crmLogEntity.
        when(crmLogEntityRepository.findByIdAndUuid(anyLong(), any(UUID.class))).thenReturn(crmLogEntity);

        // Mock crmLogEntityRepository.delete() method to return crmLogEntity.
        doNothing().when(crmLogEntityRepository).delete(any(CrmLogEntity.class));

        // Call deleteCrmLogEntity() method from crmLogMutatorService.
        var deletedCrmLogEntityDto = crmLogMutatorService.deleteCrmLog(crmLogEntityDto);

        // Assert deletedCrmLogEntityDto object is not null.
        assertNotNull(deletedCrmLogEntityDto);

        // Assert deletedCrmLogEntityDto object with crmLogEntityDto field object.
        assertEquals(crmLogEntityDto.getMessage(), deletedCrmLogEntityDto.getMessage());
        assertEquals(crmLogEntityDto.getLogType(), deletedCrmLogEntityDto.getLogType());

        assertEquals(crmLogEntityDto.getId(), deletedCrmLogEntityDto.getId());
        assertEquals(crmLogEntityDto.getUuid(), deletedCrmLogEntityDto.getUuid());
        assertEquals(crmLogEntityDto.getCreatedDate(), deletedCrmLogEntityDto.getCreatedDate());
        assertEquals(crmLogEntityDto.getLastModifiedDate(), deletedCrmLogEntityDto.getLastModifiedDate());
        assertEquals(crmLogEntityDto.getTotalModified(), deletedCrmLogEntityDto.getTotalModified());
        assertEquals(crmLogEntityDto.getIsTrashed(), deletedCrmLogEntityDto.getIsTrashed());
        assertEquals(crmLogEntityDto.getTrashedDate(), deletedCrmLogEntityDto.getTrashedDate());

        // Verify crmLogEntityRepository.save() method is called once.
        verify(crmLogEntityRepository, times(1)).delete(any(CrmLogEntity.class));

    }

    @AfterEach
    void tearDown() {
        // Reset mock objects.
        reset(crmLogEntityRepository);

        // Reset fields.
        crmLogEntityDto = null;
        crmLogEntity = null;
    }
}