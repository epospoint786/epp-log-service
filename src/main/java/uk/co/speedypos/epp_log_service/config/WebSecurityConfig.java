package uk.co.speedypos.epp_log_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilerChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests(authZ -> authZ.anyRequest().permitAll());

        return http.build();
    }

}
