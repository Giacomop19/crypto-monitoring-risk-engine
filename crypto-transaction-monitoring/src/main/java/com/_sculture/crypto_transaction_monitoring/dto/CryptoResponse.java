package com._sculture.crypto_transaction_monitoring.dto;

import java.util.List;

public class CryptoResponse {
    private String status;
    private List<CryptoData> symbols;

    public CryptoResponse() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CryptoData> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<CryptoData> symbols) {
        this.symbols = symbols;
    }
}
