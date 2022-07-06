package uk.co.speedypos.epp_log_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.speedypos.epp_log_service.entities.CrmLogEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * CRM Log Entity Repository Interface for the {@link CrmLogEntity}
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
public interface CrmLogEntityRepository extends JpaRepository<CrmLogEntity, Long> {

    List<CrmLogEntity> findAllByUserId(Long userId);

    Optional<CrmLogEntity> findByUuid(UUID uuid);

    /**
     * Finds all crm logs by user id and log type.
     * <p>
     *     <b>Important:</b> Only when confirm that crm log is existent, it will be returned.
     * </p>
     *
     * @param id (Long) of the crm log.
     * @return uuid (UUID) of the crm log.
     * @since 1.0
     */
    CrmLogEntity findByIdAndUuid(Long id, UUID uuid);
}
