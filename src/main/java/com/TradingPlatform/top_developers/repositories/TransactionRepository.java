package com.TradingPlatform.top_developers.repositories;

import com.TradingPlatform.top_developers.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    
}
