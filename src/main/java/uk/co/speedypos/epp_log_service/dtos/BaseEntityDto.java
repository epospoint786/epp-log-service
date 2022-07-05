package uk.co.speedypos.epp_log_service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Parent class for all DTOs.
 *
 * <p>
 *     <b>Important:</b> This class will be used for all microservices.<br>
 *     <b>Exclude some fields from the entity:</b> <br>
 *     - lastModifiedDate <br>
 *     - totalModified <br>
 *     - isTrashed <br>
 *     - trashedDate <br>
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
public abstract class BaseEntityDto implements Serializable {

    private Long id;
    private UUID uuid;
    private LocalDateTime createdDate;

}

