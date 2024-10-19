package com.TradingPlatform.top_developers.models;


public class Transactions {
    private String stock;
    private int quantity;
    private String type;

    // No-argument constructor
    public Transactions() {}

    // Getters and setters
    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

