package uk.co.speedypos.epp_log_service.entities;

import lombok.Getter;
import lombok.Setter;
import uk.co.speedypos.epp_log_service.enums.LogType;

import javax.persistence.*;

/**
 * Entity class for Log.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "logs")
@Setter
@Getter
public class LogEntity extends BaseEntity {

    @Column(name = "message", nullable = false, updatable = false)
    private String message;

    @Column(name = "type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private LogType type;

}