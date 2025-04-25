package org.tradingapp.services;
import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.StockDataSource;
import org.tradingapp.entities.Stock;
import java.util.Iterator;
import java.util.List;

public class DeleteStockService {
    private StockDataSource stockDataSource = GlobalDataSource.stockDataSource;

    public boolean deleteStockByCode(String code) {
        List<Stock> stocks = stockDataSource.findAll();
        Iterator<Stock> iterator = stocks.iterator();

        while (iterator.hasNext()) {
            Stock stock = iterator.next();
            if (stock.getCode().equalsIgnoreCase(code)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }
}
