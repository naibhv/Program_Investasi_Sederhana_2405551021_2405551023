package org.tradingapp.services;
import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.NationalGovermentSecuritiesDataSource;
import org.tradingapp.entities.NationalGovermentSecurities;

public class CreateNationalGovermentSecuritiesService {

    private NationalGovermentSecuritiesDataSource ngsDataSource = GlobalDataSource.nationalGovermentSecuritiesDataSource;

    public boolean create(NationalGovermentSecurities security) {
        NationalGovermentSecurities existing = ngsDataSource.findByCode(security.getCode());
        if (existing != null) {
            return false;
        }

        ngsDataSource.findAll().add(security);
        return true;
    }
}