package org.tradingapp.datasources;
import org.tradingapp.entities.Stock;
import java.util.ArrayList;
import java.util.List;

public class StockDataSource {
    private List<Stock> stocks = new ArrayList<>();

    public StockDataSource() {
        stocks.add(new Stock(
                "Bank Central Asia",
                8900,
                "BBCA"
        ));

        stocks.add(new Stock(
                "Telkom Indonesia",
                4200,
                "TLKM"
        ));

        stocks.add(new Stock(
                "Bank Mandiri",
                6750,
                "BMRI"
        ));

        stocks.add(new Stock(
                "Astra International",
                5900,
                "ASII"
        ));
    }

    public List<Stock> findAll() {
        return this.stocks;
    }

    public Stock findByCode(String code) {
        for (Stock stock : stocks) {
            if (stock.getCode().equalsIgnoreCase(code)) {
                return stock;
            }
        }
        return null;
    }
}
