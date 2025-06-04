package com.arya.api.mvc.config;

import com.arya.api.mvc.session.UsuarioSession;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor authInterceptor(UsuarioSession session) {
        return template -> {
            String token = session.getToken();
            if (token != null && !token.isBlank()) {
                template.header("Authorization", "Bearer " + token);
            }
        };
    }
}
