package uk.co.speedypos.epp_log_service.entities;

import lombok.Getter;
import lombok.Setter;
import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.enums.LogType;

import javax.persistence.*;

/**
 * Entity class for CRM log.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "crm_logs")
@Setter
@Getter
public class CrmLogEntity extends BaseEntity {

    @Column(name = "message", nullable = false, updatable = false)
    private String message;

    @Column(name = "log_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private LogType logType;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

    /**
     * Convert the CRM log entity to CRM log DTO.
     * @return {@link CrmLogEntityDto} - CRM log DTO.
     */
    public CrmLogEntityDto toDto() {

        // Create a new CRM log DTO.
        var crmLogEntityDto = new CrmLogEntityDto();
        crmLogEntityDto.setId(getId());
        crmLogEntityDto.setUuid(getUuid());
        crmLogEntityDto.setCreatedDate(getCreatedDate());
        crmLogEntityDto.setLastModifiedDate(getLastModifiedDate());
        crmLogEntityDto.setTotalModified(getTotalModified());
        crmLogEntityDto.setIsTrashed(getIsTrashed());
        crmLogEntityDto.setTrashedDate(getTrashedDate());
        crmLogEntityDto.setMessage(message);
        crmLogEntityDto.setLogType(logType);
        crmLogEntityDto.setUserId(userId);

        // Return the CRM log DTO.
        return crmLogEntityDto;
    }

}