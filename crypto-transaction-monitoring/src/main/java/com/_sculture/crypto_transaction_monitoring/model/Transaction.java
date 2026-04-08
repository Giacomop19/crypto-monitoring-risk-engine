package com._sculture.crypto_transaction_monitoring.model;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String txId;
    private Double amount;
    private LocalDateTime timestamp;
    private String riskLevel;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
