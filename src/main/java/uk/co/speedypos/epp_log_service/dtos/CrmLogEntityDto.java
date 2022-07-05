package uk.co.speedypos.epp_log_service.dtos;

import lombok.Getter;
import lombok.Setter;
import uk.co.speedypos.epp_log_service.entities.CrmLogEntity;
import uk.co.speedypos.epp_log_service.enums.LogType;

/**
 * Responsible for transfer data between CRM log controllers and services layer.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
public class CrmLogEntityDto extends BaseEntityDto {

    private String message;
    private LogType logType;
    private Long userId;

    public CrmLogEntity toEntity() {

        // Create a new CRM log entity.
        var crmLogEntity = new CrmLogEntity();
        crmLogEntity.setMessage(message);
        crmLogEntity.setLogType(logType);
        crmLogEntity.setUserId(userId);
        crmLogEntity.setId(getId());
        crmLogEntity.setUuid(getUuid());
        crmLogEntity.setCreatedDate(getCreatedDate());
        crmLogEntity.setLastModifiedDate(getLastModifiedDate());
        crmLogEntity.setTotalModified(getTotalModified());
        crmLogEntity.setIsTrashed(getIsTrashed());
        crmLogEntity.setTrashedDate(getTrashedDate());

        // Return the CRM log entity.
        return crmLogEntity;

    }
}
