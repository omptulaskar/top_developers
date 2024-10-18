package com.TradingPlatform.top_developers.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.TradingPlatform.top_developers.services.StockService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/{symbol}")
    public Map<String, Object> getStockPrice(@PathVariable String symbol) {
        Map<String, Object> response = new HashMap<>();
        try {
            double price = stockService.getStockPrice(symbol);
            response.put("success", true);
            response.put("price", price);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return response;
    }
}

