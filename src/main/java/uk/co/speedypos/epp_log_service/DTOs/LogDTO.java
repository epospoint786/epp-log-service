package uk.co.speedypos.epp_log_service.DTOs;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uk.co.speedypos.epp_log_service.documents.LogDocument;
import uk.co.speedypos.epp_log_service.enums.LogType;

/**
 * Data transfer object for {@link LogDocument}.
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LogDTO extends BaseDTO {

    private String title;
    private String description;
    private LogType logType;
    private String userId;
    private String platformId;
    private String moduleId;

    /**
     * Get fields length.
     *
     * @return length of fields
     * @since 1.0.0
     */
    public int getFieldsLength() {
        return this.getClass().getDeclaredFields().length + 7;
    }

}
