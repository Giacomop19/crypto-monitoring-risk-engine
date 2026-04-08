package com._sculture.crypto_transaction_monitoring.config;

import lombok.Getter;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
public class CryptoApiConfig {

    @Value("${crypto.external.api.base-url}")
    private String baseUrl;

    @Value("${crypto.external.api.token}")
    private String apiToken;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getBearerToken() {
        return "Bearer " + apiToken;
    }
}
