package com._sculture.crypto_transaction_monitoring.repository;

import com._sculture.crypto_transaction_monitoring.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByWalletId(Long id);
}
