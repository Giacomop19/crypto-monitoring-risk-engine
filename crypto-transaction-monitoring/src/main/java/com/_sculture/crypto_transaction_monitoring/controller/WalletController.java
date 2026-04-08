package com._sculture.crypto_transaction_monitoring.controller;

import com._sculture.crypto_transaction_monitoring.dto.WalletDto;
import com._sculture.crypto_transaction_monitoring.model.Wallet;
import com._sculture.crypto_transaction_monitoring.service.wallet.WalletService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public Wallet createWallet(@RequestBody @Validated WalletDto walletDto) {
        return walletService.createWallet(walletDto.getAddress());
    }

    @GetMapping("/{id}")
    public Wallet getWallet(@PathVariable Long id) {
        return walletService.getWallet(id);
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
