package com.udacity.stockhawk.data;

public class MessageEvent {
    public String stockSymbol;
    public MessageEvent(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }
}


