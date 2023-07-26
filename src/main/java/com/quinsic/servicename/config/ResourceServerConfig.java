package com.quinsic.servicename.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class ResourceServerConfig {

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwkSetUri;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.ignoringRequestMatchers("/**"));
        http.oauth2ResourceServer(
                c -> c.jwt(x -> x.jwkSetUri(jwkSetUri))
        );
        http.authorizeHttpRequests(c -> c
                .requestMatchers(HttpMethod.POST, "/foos/**").hasAuthority("SCOPE_read")
                .requestMatchers(HttpMethod.POST, "/foos").hasAuthority("SCOPE_write")
                .requestMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated()
        );

        http.cors(c -> c.configurationSource(req -> {
            CorsConfiguration conf = new CorsConfiguration();
            conf.setAllowedMethods(List.of("*"));
            return conf;
        }));
        return http.build();
    }
}