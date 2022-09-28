package uk.co.speedypos.epp_log_service.seeders;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Seed implements CommandLineRunner {

    private final LogSeeder logSeeder;

    @Override
    public void run(String... args) {
        seed();
    }

    private void seed() {
        logSeeder.seed();
    }
}

