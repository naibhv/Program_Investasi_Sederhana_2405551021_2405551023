package org.tradingapp.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {

    private String username;

    private List<StockRecord> stockRecords;
    private HashMap<String, NationalGovermentSecuritiesRecord> nationalGovermentSecuritiesRecords;

    public Portfolio(String username) {
        this.username = username;
        this.stockRecords = new ArrayList<>();
        this.nationalGovermentSecuritiesRecords = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<StockRecord> getStockRecords() {
        return stockRecords;
    }

    public void setStockRecords(List<StockRecord> stockRecords) {
        this.stockRecords = stockRecords;
    }

    public HashMap<String, NationalGovermentSecuritiesRecord> getNationalGovermentSecuritiesRecords() {
        return nationalGovermentSecuritiesRecords;
    }

    public void setNationalGovermentSecuritiesRecords(HashMap<String, NationalGovermentSecuritiesRecord> nationalGovermentSecuritiesRecords) {
        this.nationalGovermentSecuritiesRecords = nationalGovermentSecuritiesRecords;
    }

    public List<StockRecord> groupStockRecordByCode(){
        Map<String, StockRecord> grouped = new HashMap<>();

        for (StockRecord record : stockRecords) {
            String code = record.getCode();
            if (!grouped.containsKey(code)) {
                grouped.put(code, new StockRecord(code, record.getPrice()*record.getAmount(), record.getAmount()));
            } else {
                StockRecord existing = grouped.get(code);
                int totalAmount = existing.getAmount() + record.getAmount();
                int totalPrice = existing.getPrice() + (record.getPrice() * record.getAmount());

                existing.setAmount(totalAmount);
                existing.setPrice(totalPrice);
            }
        }

        return new ArrayList<>(grouped.values());

    }

    public static class StockRecord{
        private String code;
        private Integer price;
        private Integer amount;

        public StockRecord(String code, Integer price, Integer amount) {
            this.code = code;
            this.price = price;
            this.amount = amount;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }
    }

    public static class NationalGovermentSecuritiesRecord{
        private String code;
        private Integer investmentAmount;

        public NationalGovermentSecuritiesRecord(String code, Integer investmentAmount) {
            this.code = code;
            this.investmentAmount = investmentAmount;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Integer getInvestmentAmount() {
            return investmentAmount;
        }

        public void setInvestmentAmount(Integer investmentAmount) {
            this.investmentAmount = investmentAmount;
        }


    }

}