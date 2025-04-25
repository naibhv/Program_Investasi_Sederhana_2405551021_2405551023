package org.tradingapp.services;

import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.NationalGovermentSecuritiesDataSource;
import org.tradingapp.datasources.PortfolioDataSource;
import org.tradingapp.entities.NationalGovermentSecurities;
import org.tradingapp.entities.Portfolio;
import org.tradingapp.entities.Portfolio.NationalGovermentSecuritiesRecord;

public class NationalGovermentSecuritiesSimulation {

    private NationalGovermentSecuritiesDataSource nationalGovermentSecuritiesDataSource = GlobalDataSource.nationalGovermentSecuritiesDataSource;
    private PortfolioDataSource portfolioDataSource = GlobalDataSource.portfolioDataSource;

    public double simulateMonthlyCoupon(String username, String code) {
        NationalGovermentSecurities nationalGovermentSecurities = nationalGovermentSecuritiesDataSource.findByCode(code);
        if (nationalGovermentSecurities == null) {
            return -1;
        }

        Portfolio portfolio = portfolioDataSource.findByUsername(username);
        if (portfolio == null) {
            return -1;
        }

        int nominalInvestment = portfolio.getNationalGovermentSecuritiesRecords()
                .getOrDefault(code,new NationalGovermentSecuritiesRecord(code , 0))
                .getInvestmentAmount();

        if (nominalInvestment == 0) {
            return 0;
        }

        double annualInterest = nationalGovermentSecurities.getInterestRate() / 100.0;
        double monthlyCoupon = (annualInterest / 12.0) * 0.9 * nominalInvestment;

        return monthlyCoupon;
    }
}