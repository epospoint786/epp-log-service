package uk.co.speedypos.epp_log_service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Responsible for initialization require bean.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
