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
 * <b>Important:</b> This is shared by all microservices.<br/><br/>
 *
 * <b>Exclude some fields:</b>
 *     <ul>
 *         <li>lastModifiedDate</li>
 *         <li>totalModified</li>
 *         <li>isTrashed</li>
 *         <li>trashedDate</li>
 *     </ul>
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

