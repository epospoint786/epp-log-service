package uk.co.speedypos.epp_log_service.seeders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uk.co.speedypos.epp_log_service.repositories.LogMutatorRepository;

@Component
@RequiredArgsConstructor
public class LogSeeder {

    private final LogMutatorRepository logMutatorRepository;

    public void seed() {
//        logMutatorRepository.deleteAll().block();
//
//        for (var i = 0; i < 10; i++) {
//            val logDocument = new LogDocument();
//            logDocument.setTitle("Log " + i);
//            logDocument.setDescription("Log " + i + " description");
//            logDocument.setLogType(LogType.getRandom());
//            logDocument.setPlatformId(new ObjectId().toHexString());
//            logMutatorRepository.save(logDocument).block();
//        }
    }
}
