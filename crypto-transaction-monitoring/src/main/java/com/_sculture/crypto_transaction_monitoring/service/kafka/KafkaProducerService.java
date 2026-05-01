package com._sculture.crypto_transaction_monitoring.service.kafka;

import com._sculture.crypto_transaction_monitoring.event.PortfolioEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, PortfolioEvent> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, PortfolioEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPortfolioEvent(PortfolioEvent event) {
        kafkaTemplate.send("portfolio-events", event);
    }
}
