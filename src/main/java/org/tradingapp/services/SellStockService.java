package org.tradingapp.services;

import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.StockDataSource;
import org.tradingapp.entities.Customer;
import org.tradingapp.entities.Stock;

public class SellStockService {
    private StockDataSource stockDataSource = GlobalDataSource.stockDataSource;

    private MinusStockService minusStockService = new MinusStockService();

    public boolean sellStock(Customer customer, String code, Integer amount) {
        Stock stock = stockDataSource.findByCode(code);
        if (stock == null) {
            return false;
        }
        return minusStockService.MinusStockInPortfolio(customer,code,amount);
    }
}
