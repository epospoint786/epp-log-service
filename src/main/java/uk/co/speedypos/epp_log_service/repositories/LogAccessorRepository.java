package uk.co.speedypos.epp_log_service.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import uk.co.speedypos.epp_log_service.documents.LogDocument;

/**
 * Core interface for {@link LogDocument} data accessing operations using Spring Data Reactive MongoDB.
 *
 * @author Supto Purakayasto
 * @version 1.0.0
 * @since 1.0.0
 */
public interface LogAccessorRepository extends ReactiveMongoRepository<LogDocument, String> { }
