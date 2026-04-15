package com._sculture.crypto_transaction_monitoring.service.portfolio;

import com._sculture.crypto_transaction_monitoring.model.Wallet;

import java.util.Map;

public interface PortfolioService {

    Map<String, Object> calculatePortfolioBalance(Wallet wallet);
}
