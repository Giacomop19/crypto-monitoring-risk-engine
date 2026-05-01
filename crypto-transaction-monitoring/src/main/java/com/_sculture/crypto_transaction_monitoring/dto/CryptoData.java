package com._sculture.crypto_transaction_monitoring.dto;

public class CryptoData {
    private String symbol;
    private String last;
    private String last_btc;
    private String lowest;
    private String highest;
    private String date;
    private String daily_change_percentage;
    private String source_exchange;

    public CryptoData() {}

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLast_btc() {
        return last_btc;
    }

    public void setLast_btc(String last_btc) {
        this.last_btc = last_btc;
    }

    public String getLowest() {
        return lowest;
    }

    public void setLowest(String lowest) {
        this.lowest = lowest;
    }

    public String getHighest() {
        return highest;
    }

    public void setHighest(String highest) {
        this.highest = highest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDaily_change_percentage() {
        return daily_change_percentage;
    }

    public void setDaily_change_percentage(String daily_change_percentage) {
        this.daily_change_percentage = daily_change_percentage;
    }

    public String getSource_exchange() {
        return source_exchange;
    }

    public void setSource_exchange(String source_exchange) {
        this.source_exchange = source_exchange;
    }
}
