package uk.co.speedypos.epp_log_service.entities;

import lombok.Getter;
import lombok.Setter;
import uk.co.speedypos.epp_log_service.enums.LogType;
import uk.co.speedypos.epp_log_service.enums.UserType;

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

    @Column(name = "log_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private LogType logType;

    @Column(name = "user_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

}