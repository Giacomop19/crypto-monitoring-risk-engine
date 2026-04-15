package com._sculture.crypto_transaction_monitoring.controller;

import com._sculture.crypto_transaction_monitoring.dto.WalletDto;
import com._sculture.crypto_transaction_monitoring.model.Wallet;
import com._sculture.crypto_transaction_monitoring.service.portfolio.PortfolioService;
import com._sculture.crypto_transaction_monitoring.service.wallet.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    @Autowired
    private PortfolioService portfolioService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public Wallet createWallet(@RequestBody @Validated WalletDto walletDto) {
        return walletService.createWallet(walletDto.getAssets());
    }

    @GetMapping("/{id}")
    public Wallet getWallet(@PathVariable Long id) {
        return walletService.getWallet(id);
    }

    @GetMapping("/{id}/portfolio")
    public Map<String, Object> getPortfolio(@PathVariable Long id) {
        Wallet wallet = walletService.getWallet(id);
        return portfolioService.calculatePortfolioBalance(wallet);
    }
}
