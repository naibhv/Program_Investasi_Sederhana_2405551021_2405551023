package org.tradingapp.entities;

public class Stock {
    private String code;
    private String companyName;
    private Integer price;

    public Stock(String companyName, Integer price, String code) {
        this.companyName = companyName;
        this.price = price;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
