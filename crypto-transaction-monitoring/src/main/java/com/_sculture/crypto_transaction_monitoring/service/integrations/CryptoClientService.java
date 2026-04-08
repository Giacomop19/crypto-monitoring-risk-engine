package com._sculture.crypto_transaction_monitoring.service.integrations;

import com._sculture.crypto_transaction_monitoring.config.CryptoApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class CryptoClientService {

    private static final Logger logger = LoggerFactory.getLogger(CryptoClientService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CryptoApiConfig cryptoApiConfig;

    public Double getData(String symbol) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", cryptoApiConfig.getBearerToken());
            HttpEntity<String> request = new HttpEntity<>(headers);
            String url = cryptoApiConfig.getBaseUrl() + "/getData?symbol=" + symbol;

            ResponseEntity<Double> response = restTemplate.exchange(url, HttpMethod.GET, request, Double.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                logger.info("Successfully fetched crypto data for symbol: {}", symbol);
                return response.getBody();
            } else {
                logger.warn("Unexpected response status for symbol {}: {}", symbol, response.getStatusCode());
                return null;
            }
        } catch (RestClientException e) {
            logger.error("Error fetching crypto data for symbol {}: {}", symbol, e.getMessage(), e);
            return null;
        }
    }
}
