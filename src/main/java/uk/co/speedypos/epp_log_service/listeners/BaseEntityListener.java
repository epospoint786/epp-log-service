package uk.co.speedypos.epp_log_service.listeners;


import uk.co.speedypos.epp_log_service.entities.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base entity listener class for all entities.
 *
 * <p>
 *     <b>Important:</b> This class will be used for all microservices.
 * </p>
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
public class BaseEntityListener {

    /**
     * This method is used to listen pre persist event of BaseEntity.
     *
     * @param baseEntity This is the {@link BaseEntity} that is going to be persisted.
     * @since 1.0
     */
    @PrePersist
    public void prePersist(BaseEntity baseEntity) {

        baseEntity.setUuid(UUID.randomUUID());
        baseEntity.setCreatedDate(LocalDateTime.now());
        baseEntity.setTotalModified(0L);
        baseEntity.setIsTrashed(false);

    }

    /**
     * This method is used to listen pre update event of BaseEntity.
     *
     * @param baseEntity This is the {@link BaseEntity} that is going to be updated.
     * @since 1.0
     */
    @PreUpdate
    public void preUpdate(BaseEntity baseEntity) {

        baseEntity.setLastModifiedDate(LocalDateTime.now());
        baseEntity.setTotalModified(baseEntity.getTotalModified() + 1);

        // Set trashedDate
        if (baseEntity.getIsTrashed() && baseEntity.getTrashedDate() == null) {
            baseEntity.setTrashedDate(LocalDateTime.now());
        }

    }

    /**
     * This method is used to listen pre remove event of BaseEntity.
     *
     * @param baseEntity This is the {@link BaseEntity} that is going to be removed.
     * @since 1.0
     */
    @PreRemove
    public void preRemove(BaseEntity baseEntity) {

        // do nothing

    }

    /**
     * This method is used to listen post load event of BaseEntity.
     *
     * @param baseEntity This is the {@link BaseEntity} that is going to be loaded.
     * @since 1.0
     */
    @PostLoad
    public void postLoad(BaseEntity baseEntity) {

        // do nothing

    }

    /**
     * This method is used to listen post remove event of BaseEntity.
     *
     * @param baseEntity This is the {@link BaseEntity} that is going to be removed.
     * @since 1.0
     */
    @PostRemove
    public void postRemove(BaseEntity baseEntity) {

        // do nothing

    }

    /**
     * This method is used to listen post update event of BaseEntity.
     *
     * @param baseEntity This is the {@link BaseEntity} that is going to be updated.
     * @since 1.0
     */
    @PostUpdate
    public void postUpdate(BaseEntity baseEntity) {

        // do nothing

    }

    /**
     * This method is used to listen post persist event of BaseEntity.
     *
     * @param baseEntity This is the {@link BaseEntity} that is going to be persisted.
     * @since 1.0
     */
    @PostPersist
    public void postPersist(BaseEntity baseEntity) {

        // do nothing

    }
}
