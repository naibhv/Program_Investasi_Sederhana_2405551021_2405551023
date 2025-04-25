package org.tradingapp.services;

import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.StockDataSource;
import org.tradingapp.entities.Stock;

public class UpdateStockService {
    private StockDataSource stockDataSource = GlobalDataSource.stockDataSource;

    public boolean updateStockPrice(String code, Integer newPrice) {
        Stock stock = stockDataSource.findByCode(code);
        if (stock != null) {
            stock.setPrice(newPrice);
            return true;
        }
        return false;
    }
}
