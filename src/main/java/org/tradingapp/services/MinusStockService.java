package org.tradingapp.services;

import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.PortfolioDataSource;
import org.tradingapp.entities.Customer;
import org.tradingapp.entities.Portfolio;
import java.util.List;

public class MinusStockService {

    private PortfolioDataSource portfolioDataSource = GlobalDataSource.portfolioDataSource;

    public Boolean MinusStockInPortfolio(Customer customer, String code, Integer amountToSell){
        Portfolio portfolio = portfolioDataSource.findByUsername(
                customer.getUsername()
        );

        final Integer amountToSellForLambda = amountToSell;

        boolean isExistAndSufficient = portfolio.groupStockRecordByCode()
                .stream()
                .anyMatch(stockRecord ->
                        stockRecord.getCode().equals(code) &&
                                stockRecord.getAmount() >= amountToSellForLambda);

        if(!isExistAndSufficient) return false;

        for(Portfolio.StockRecord stockRecord : portfolio.getStockRecords()){
            if(!stockRecord.getCode().equals(code))  continue;
            int amountStock = stockRecord.getAmount();
            if(amountStock >= amountToSell){
                stockRecord.setAmount(amountStock - amountToSell);
                break;
            }
            amountToSell = amountToSell - stockRecord.getAmount();
            stockRecord.setAmount(0);
        }

        portfolio.getStockRecords().removeIf(stockRecord -> stockRecord.getAmount() == 0);
        return true;
    }
}
