package uk.co.speedypos.epp_log_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EppLogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EppLogServiceApplication.class, args);
	}

}
