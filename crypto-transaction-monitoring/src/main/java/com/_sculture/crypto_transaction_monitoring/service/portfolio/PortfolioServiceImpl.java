package com._sculture.crypto_transaction_monitoring.service.portfolio;

import com._sculture.crypto_transaction_monitoring.model.Wallet;
import com._sculture.crypto_transaction_monitoring.service.integrations.CryptoClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private final CryptoClientService cryptoClientService;

    public PortfolioServiceImpl(CryptoClientService cryptoClientService) {
        this.cryptoClientService = cryptoClientService;
    }

    public Map<String, Object> calculatePortfolioBalance(Wallet wallet) {
        double totalValue = 0;
        Map<String, Double> breakdown = new HashMap<>();
        for(Map.Entry<String, Double> entry : wallet.getAssets().entrySet()) {
            String symbol = entry.getKey();
            double amount = entry.getValue();
            double price = cryptoClientService.getData(symbol);
            double value = amount * price;
            breakdown.put(symbol, value);
            totalValue += value;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("totalValue", totalValue);
        result.put("breakdown", breakdown);
        return result;
    }
}
