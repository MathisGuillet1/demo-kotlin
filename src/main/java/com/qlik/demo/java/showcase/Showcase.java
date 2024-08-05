package com.qlik.demo.java.showcase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Map;
import java.util.Optional;

import static org.springframework.security.authorization.AuthorityAuthorizationManager.hasAuthority;

// Just showcasing stuff
public class Showcase {

    private static final Map<String, User> usersById = Map.of(
            "8ab755ba-3db8-4715-bf4e-0627928c2586",
            new User("Mathis", "mathis@fake.com"),
            "d9163211-4d79-45c4-8ad9-bb35916db86d",
            new User("John", "john@fake.com")
    );

    public void sendEmailToUser(String userId) {
        final var userEmail = Optional.ofNullable(usersById.get(userId))
                .map(User::email)
                .orElseThrow(() -> new IllegalStateException("User with id " + userId + " was not found"));

        if (userEmail != null && !userEmail.isEmpty()) {
            // Do something with user email...
            System.out.println(userEmail);
        }
    }
}

record User(String name, String email) {
}

@Configuration
@EnableWebSecurity
class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/health/**").permitAll()
                        .requestMatchers("/metrics").access(hasAuthority("metrics:read"))
                        .anyRequest().authenticated()
                )
                .csrf(CsrfConfigurer::disable)
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwkSetUri("https://idp.example.com/.well-known/jwks.json")
                        )
                );
        return http.build();
    }
}
