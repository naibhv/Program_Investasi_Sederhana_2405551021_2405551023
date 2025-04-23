package org.tradingapp.datasources;

import org.tradingapp.entities.Portfolio;
import java.util.HashMap;
import java.util.Map;

public class PortfolioDataSource {

    private Map<String, Portfolio> portfolioMap = new HashMap<>();

    public PortfolioDataSource() {
        Portfolio user1 = new Portfolio("Aksara Mulia");
        user1.getStockRecords().add(new Portfolio.StockRecord("BBCA", 8500, 10));
        user1.getStockRecords().add(new Portfolio.StockRecord("BBCA", 9000, 5));
        user1.getNationalGovermentSecuritiesRecords().put("SBN001",new Portfolio.NationalGovermentSecuritiesRecord("SBN001", 1000000));

        Portfolio user2 = new Portfolio("Bunga Karina");
        user2.getStockRecords().add(new Portfolio.StockRecord("TLKM", 4200, 20));
        user2.getNationalGovermentSecuritiesRecords().put("SBN003",new Portfolio.NationalGovermentSecuritiesRecord("SBN003", 1500000));

        portfolioMap.put("Aksara Mulia", user1);
        portfolioMap.put("Bunga Karina", user2);
    }

    public Portfolio findByUsername(String username) {
        return portfolioMap.get(username);
    }

    public void save(Portfolio portfolio) {
        portfolioMap.put(portfolio.getUsername(), portfolio);
    }

    public void deleteByUsername(String username) {
        portfolioMap.remove(username);
    }

    public boolean exists(String username) {
        return portfolioMap.containsKey(username);
    }

    public void clearAll() {
        portfolioMap.clear();
    }
}