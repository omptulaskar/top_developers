package com.TradingPlatform.top_developers.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.TradingPlatform.top_developers.services.TradingService;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/trade")
public class TradingController {

    @Autowired
    private TradingService tradingService;

    @PostMapping
    public Map<String, Object> executeTrade(@RequestBody Map<String, Object> tradeData) {
        String stockSymbol = (String) tradeData.get("stockSymbol");
        int quantity = (Integer) tradeData.get("quantity");
        String type = (String) tradeData.get("type");

        Map<String, Object> response = new HashMap<>();
        try {
            boolean success = tradingService.executeTrade(stockSymbol, quantity, type);
            response.put("success", success);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return response;
    }
}

