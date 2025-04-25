package org.tradingapp.services;

import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.StockDataSource;
import org.tradingapp.entities.Customer;
import org.tradingapp.entities.Stock;

public class BuyStockService {
    private StockDataSource stockDataSource = GlobalDataSource.stockDataSource;

    private AddStockInPortfolio addStockInPortfolio = new AddStockInPortfolio();

    public boolean buyStock(Customer customer, String code, Integer amount) {
        Stock stock = stockDataSource.findByCode(code);
        if (stock == null) {
            return false;
        }

        addStockInPortfolio.add(customer.getUsername(), code, stock.getPrice(), amount);
        return true;
    }
}
