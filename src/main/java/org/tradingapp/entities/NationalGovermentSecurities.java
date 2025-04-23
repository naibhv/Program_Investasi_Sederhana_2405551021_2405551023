package org.tradingapp.entities;

import java.time.LocalDate;

public class NationalGovermentSecurities {

    private String code;
    private String name;
    private Double interestRate;
    private Integer onMonth;
    private LocalDate maturityDate;
    private Integer nationalQuota;

    public NationalGovermentSecurities(
            String code,
            String name,
            Double interestRate,
            Integer onMonth,
            LocalDate maturityDate,
            Integer nationalQuota
    ) {
        this.code = code;
        this.name = name;
        this.interestRate = interestRate;
        this.onMonth = onMonth;
        this.maturityDate = maturityDate;
        this.nationalQuota = nationalQuota;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getOnMonth() {
        return onMonth;
    }

    public void setOnMonth(Integer onMonth) {
        this.onMonth = onMonth;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Integer getNationalQuota() {
        return nationalQuota;
    }

    public void setNationalQuota(Integer nationalQuota) {
        this.nationalQuota = nationalQuota;
    }
}