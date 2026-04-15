package com._sculture.crypto_transaction_monitoring.service.wallet;

import com._sculture.crypto_transaction_monitoring.model.Wallet;

import java.util.Map;

public interface WalletService {

     Wallet createWallet(Map<String, Double> assets);
     Wallet getWallet(Long id);
     Wallet updateWallet(Long id, String symbol, Double amount);
}

