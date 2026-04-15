package com._sculture.crypto_transaction_monitoring.dto;

import lombok.Data;

import java.util.Map;

@Data
public class WalletDto {

    private Map<String, Double> assets;
}
