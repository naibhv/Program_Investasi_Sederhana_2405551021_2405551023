package org.tradingapp.services;
import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.datasources.NationalGovermentSecuritiesDataSource;
import org.tradingapp.entities.NationalGovermentSecurities;
import java.util.List;

public class GetNationalGovermentSecuritiesService {

    private NationalGovermentSecuritiesDataSource ngsDataSource = GlobalDataSource.nationalGovermentSecuritiesDataSource;

    public List<NationalGovermentSecurities> getAllSecurities() {
        return ngsDataSource.findAll();
    }

    public NationalGovermentSecurities getSecurityByCode(String code) {
        return ngsDataSource.findByCode(code);
    }
}