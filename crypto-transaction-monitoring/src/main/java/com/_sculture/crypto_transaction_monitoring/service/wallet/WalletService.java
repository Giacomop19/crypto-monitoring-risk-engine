package com._sculture.crypto_transaction_monitoring.service.wallet;

import com._sculture.crypto_transaction_monitoring.model.Wallet;

public interface WalletService {

     Wallet createWallet(String address);
     Wallet getWallet(Long id);
}

