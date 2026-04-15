package com._sculture.crypto_transaction_monitoring.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "wallet_assets", joinColumns = @JoinColumn(name = "wallet_id"))
    @MapKeyColumn(name = "symbol")
    @Column(name = "amount")
    private Map<String, Double> assets;

}
