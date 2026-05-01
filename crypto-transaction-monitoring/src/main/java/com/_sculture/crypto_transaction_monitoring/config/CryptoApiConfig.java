package com._sculture.crypto_transaction_monitoring.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
public class CryptoApiConfig {

    @Value("${crypto.url}")
    private String baseUrl;

    @Value("${crypto.token}")
    private String bearerToken;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getBearerToken() {
        return "Bearer " + bearerToken;
    }
}
