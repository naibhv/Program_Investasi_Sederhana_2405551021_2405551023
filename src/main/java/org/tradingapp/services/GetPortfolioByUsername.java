package org.tradingapp.services;

import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.PortfolioDataSource;
import org.tradingapp.entities.Portfolio;

public class GetPortfolioByUsername {
    private PortfolioDataSource portfolioDataSource = GlobalDataSource.portfolioDataSource;

    public Portfolio getPortfolio(String username) {
        Portfolio portfolio = portfolioDataSource.findByUsername(username);
        if (portfolio == null) {
            return null;
        }
        return portfolio;
    }
}