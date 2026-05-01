package com._sculture.crypto_transaction_monitoring.event;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioEvent {

    private Long walletId;
    private Double totalValue;
    private Map<String, Double> assets;
}
