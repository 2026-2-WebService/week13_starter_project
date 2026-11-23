package edu.handong.week13.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // TODO A-1: Allow public access to "/" and "/style.css".
        // TODO A-2: Allow only ADMIN to access "/admin".
        // TODO A-3: Require authentication for "/mypage" and all other URLs.
        // Start here: everything is permitted so you can compare BEFORE vs AFTER.
        http.authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll()
        ).formLogin(Customizer.withDefaults());
        return http.build();
    }
}
