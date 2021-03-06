package uk.co.speedypos.epp_log_service.entities;

import lombok.Getter;
import lombok.Setter;
import uk.co.speedypos.epp_log_service.listeners.BaseEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entity class for all entities.
 *
 * <p>
 *  <strong>Important:</strong> This is shared by all microservices.
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
@Setter
@Getter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
    @TableGenerator(name = "table_generator", table = "table_generator", pkColumnName = "table_generator_name", valueColumnName = "table_generator_value", allocationSize = 1, initialValue = 1000000000)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "uuid", nullable = false, updatable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name = "total_modified", nullable = false)
    private Long totalModified;

    @Column(name = "is_trashed", nullable = false)
    private Boolean isTrashed;

    @Column(name = "trashed_date")
    private LocalDateTime trashedDate;

}
