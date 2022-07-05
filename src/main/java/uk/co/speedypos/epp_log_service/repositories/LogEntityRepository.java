package uk.co.speedypos.epp_log_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.speedypos.epp_log_service.entities.LogEntity;

/**
 * Log Entity Repository Interface for the {@link LogEntity}
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
public interface LogEntityRepository extends JpaRepository<LogEntity, Long> {}
