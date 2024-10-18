package com.TradingPlatform.top_developers.services;

import com.TradingPlatform.top_developers.models.Transaction;
import com.TradingPlatform.top_developers.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TradingService {
    @Autowired
    private TransactionRepository transactionrepository;

    public boolean executeTrade(String stockSymbol, int quantity, String type) {
        // TODO: Add logic to buy/sell stocks, interact with APIs like Yahoo Finance
        Transaction transaction = new Transaction();
        transaction.setStock(stockSymbol);
        transaction.setQuantity(quantity);
        transaction.setType(type);

        transactionRepository.save(transaction);

        System.out.println("Executing trade for stock: " + stock + " with quantity: " + quantity);
        return true;
    }
}

