package org.tradingapp.services;
import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.NationalGovermentSecuritiesDataSource;
import org.tradingapp.entities.Customer;
import org.tradingapp.entities.NationalGovermentSecurities;

public class BuyNationalGovermentSecuritiesService {

    private NationalGovermentSecuritiesDataSource ngsDataSource = GlobalDataSource.nationalGovermentSecuritiesDataSource;

    private AddNationalGovermentSecuritiesInPortfolio addNationalGovermentSecuritiesInPortfolio = new AddNationalGovermentSecuritiesInPortfolio();

    public boolean buySecurity(Customer customer, String code, Integer investation) {
        NationalGovermentSecurities security = ngsDataSource.findByCode(code);
        if (security == null) {
            return false;
        }
        addNationalGovermentSecuritiesInPortfolio.add(customer.getUsername() , code , investation);
        return true;
    }
}