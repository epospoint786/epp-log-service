package uk.co.speedypos.epp_log_service.seeders;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uk.co.speedypos.epp_log_service.dtos.CrmLogEntityDto;
import uk.co.speedypos.epp_log_service.enums.LogType;
import uk.co.speedypos.epp_log_service.services.interfaces.crm.CrmLogMutatorService;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class CrmLogSeeder implements CommandLineRunner {

    private final CrmLogMutatorService crmLogMutatorService;

    @Override
    public void run(String... args) {
//         seed();
    }

    private void seed() {
        log.info("Seeding crm log into the database...starting");

        var faker = new Faker();

        for (int i = 0; i < 10000; i++) {

            // Create crmLogEntityDto.
            var crmLogEntityDto = new CrmLogEntityDto();
            crmLogEntityDto.setMessage(faker.lorem().sentence());
            crmLogEntityDto.setLogType(LogType.getRandom());
            crmLogEntityDto.setUserId((long) faker.number().numberBetween(1, 100));
            crmLogEntityDto.setLastModifiedDate(LocalDateTime.now());
            crmLogEntityDto.setTotalModified((long) faker.number().numberBetween(1, 5));
            crmLogEntityDto.setIsTrashed(faker.bool().bool());
            crmLogEntityDto.setTrashedDate(LocalDateTime.now());

            // Call createCrmLog method from CrmLogMutatorService to create crmLogEntityDto.
            crmLogMutatorService.createCrmLog(crmLogEntityDto);

        }

        log.info("Seeding crm log into the database...finished");
    }
}
