package com.TradingPlatform.top_developers.services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {

    private final String API_KEY = "eHp9sK7cvI_JF4HyNNjDp6ypqNbWG4rW";
    private final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=";

    public double getStockPrice(String stockSymbol) throws Exception {
        String url = BASE_URL + stockSymbol + "&interval=1min&apikey=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        // Extract stock price from JSON response (this will vary depending on API format)
        // Example code to extract data from JSON response
        // Parse JSON to extract latest stock price

        // For now, let's assume you successfully parsed the JSON response and got the price
        double latestPrice = parsePriceFromResponse(response);

        return latestPrice;
    }

    private double parsePriceFromResponse(String response) {
        // Dummy parser - implement real parsing logic here
        return 150.0; // Replace with actual JSON parsing logic
    }
}

