package org.tradingapp.services;

import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.PortfolioDataSource;
import org.tradingapp.entities.Portfolio;

public class AddNationalGovermentSecuritiesInPortfolio {
    private PortfolioDataSource portfolioDataSource = GlobalDataSource.portfolioDataSource;

    public void add(String username, String code, int amount) {
        Portfolio portfolio = portfolioDataSource.findByUsername(username);

        if (portfolio == null) {
            portfolio = new Portfolio(username);
        }

        portfolio.getNationalGovermentSecuritiesRecords().computeIfAbsent(code ,
                k-> new Portfolio.NationalGovermentSecuritiesRecord(code, 0));

        Portfolio.NationalGovermentSecuritiesRecord record = portfolio.getNationalGovermentSecuritiesRecords().get(code);
        record.setInvestmentAmount(record.getInvestmentAmount()+amount);


        portfolioDataSource.save(portfolio);
    }
}