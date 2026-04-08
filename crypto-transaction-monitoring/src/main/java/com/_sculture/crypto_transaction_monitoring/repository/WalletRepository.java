package com._sculture.crypto_transaction_monitoring.repository;

import com._sculture.crypto_transaction_monitoring.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
