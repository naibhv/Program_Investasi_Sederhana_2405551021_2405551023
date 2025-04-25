package org.tradingapp.services;

import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.PortfolioDataSource;
import org.tradingapp.entities.Portfolio;

public class AddStockInPortfolio {
    private PortfolioDataSource portfolioDataSource = GlobalDataSource.portfolioDataSource;

    public void add(String username, String code, int price, int amount) {
        Portfolio portfolio = portfolioDataSource.findByUsername(username);

        if (portfolio == null) {
            portfolio = new Portfolio(username);
        }

        Portfolio.StockRecord newStock = new Portfolio.StockRecord(code, price, amount);
        portfolio.getStockRecords().add(newStock);

        portfolioDataSource.save(portfolio);
    }
}
