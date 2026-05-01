package com._sculture.crypto_transaction_monitoring.service.wallet;

import com._sculture.crypto_transaction_monitoring.model.Wallet;
import com._sculture.crypto_transaction_monitoring.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Transactional
    public Wallet createWallet(Map<String, Double> assets) {
        Wallet wallet = Wallet.builder()
                .assets(assets != null ? assets : new HashMap<>())
                .build();
        return walletRepository.save(wallet);
    }

    public Wallet getWallet(Long id) {
        return walletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
    }

    public Wallet updateWallet(Long id, String symbol, Double amount) {
        Wallet wallet = getWallet(id);
        wallet.getAssets().put(symbol, amount);
        return walletRepository.save(wallet);
    }
}
