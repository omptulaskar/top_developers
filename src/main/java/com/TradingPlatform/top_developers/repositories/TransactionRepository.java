package com.TradingPlatform.top_developers.repositories;

import com.TradingPlatform.top_developers.models.Transactions;
import jakarta.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findByStock(String stockSymbol);

    List<Transactions> findByType(String type);

    List<Transactions> findByQuantity(int quantity);

    List<Transactions> findByStockAndType(String stockSymbol, String type);

    @Query("SELECT t FROM Transaction t WHERE t.stock = :stockSymbol")
    List<Transaction> findAllTransactionsForStock(@Param("stockSymbol") String stockSymbol);

    @Query("SELECT SUM(t.quantity) FROM Transaction t WHERE t.stock = :stockSymbol")
    Long findTotalQuantityForStock(@Param("stockSymbol") String stockSymbol);

    @Query("SELECT AVG(t.price) FROM Transaction t WHERE t.stock = :stockSymbol")
    Double findAveragePriceForStock(@Param("stockSymbol") String stockSymbol);

    @Query("SELECT t FROM Transaction t WHERE t.stock = :stockSymbol ORDER BY t.timestamp DESC")
    Transaction findMostRecentTransactionForStock(@Param("stockSymbol") String stockSymbol);

}
