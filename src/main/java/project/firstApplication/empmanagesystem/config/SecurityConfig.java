package project.firstApplication.empmanagesystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 2. Define authorization rules
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // All endpoints require authentication
                )

                // 3. Enable Basic Authentication
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
