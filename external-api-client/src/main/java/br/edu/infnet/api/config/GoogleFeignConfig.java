package br.edu.infnet.api.config;

import br.edu.infnet.api.service.GoogleTokenService;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleFeignConfig {

    private final GoogleTokenService googleTokenService;

    public GoogleFeignConfig(GoogleTokenService googleTokenService) {
        this.googleTokenService = googleTokenService;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            String token = googleTokenService.getValidAccessToken();
            requestTemplate.header("Authorization", "Bearer " + token);
            requestTemplate.header("Accept", "application/json");
        };
    }
}