package org.tradingapp.services;
import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.StockDataSource;
import org.tradingapp.entities.Stock;

public class CreateStockService {

    private StockDataSource stockDataSource = GlobalDataSource.stockDataSource;

    public boolean create(Stock stock) {
        Stock existing = stockDataSource.findByCode(stock.getCode());
        if (existing != null) {
            return false;
        }

        stockDataSource.findAll().add(stock);
        return true;
    }
}
