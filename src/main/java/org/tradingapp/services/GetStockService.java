package org.tradingapp.services;
import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.StockDataSource;
import org.tradingapp.entities.Stock;
import java.util.List;

public class GetStockService {
    private StockDataSource stockDataSource = GlobalDataSource.stockDataSource;

    public List<Stock> getAllStocks() {
        return stockDataSource.findAll();
    }

    public Stock getStockByCode(String code) {
        return stockDataSource.findByCode(code);
    }
}
