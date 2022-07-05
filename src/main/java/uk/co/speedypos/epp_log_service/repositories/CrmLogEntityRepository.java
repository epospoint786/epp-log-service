package uk.co.speedypos.epp_log_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.speedypos.epp_log_service.entities.CrmLogEntity;

/**
 * CRM Log Entity Repository Interface for the {@link CrmLogEntity}
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
public interface CrmLogEntityRepository extends JpaRepository<CrmLogEntity, Long> {}
