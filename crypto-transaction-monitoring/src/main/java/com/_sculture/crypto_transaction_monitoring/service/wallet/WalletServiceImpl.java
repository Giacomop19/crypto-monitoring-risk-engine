package com._sculture.crypto_transaction_monitoring.service.wallet;

import com._sculture.crypto_transaction_monitoring.model.Wallet;
import com._sculture.crypto_transaction_monitoring.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

     public WalletServiceImpl(WalletRepository walletRepository) {
         this.walletRepository = walletRepository;
     }

    public Wallet createWallet(String address) {
        Wallet wallet = Wallet.builder()
                .address(address)
                .balance(0.0)
                .build();
        return walletRepository.save(wallet);
    }

    public Wallet getWallet(Long id) {
        return walletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
    }
}
