package org.tradingapp.datasources;
import org.tradingapp.entities.NationalGovermentSecurities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NationalGovermentSecuritiesDataSource {
    private List<NationalGovermentSecurities> nationalGovermentSecuritiesList = new ArrayList<>();

    public NationalGovermentSecuritiesDataSource() {
        nationalGovermentSecuritiesList.add(new NationalGovermentSecurities(
                "SBN001",
                "SBN Ritel ORI021",
                6.15,
                36,
                LocalDate.of(2026, 4, 15),
                100000
        ));

        nationalGovermentSecuritiesList.add(new NationalGovermentSecurities(
                "SBN002",
                "Sukuk Tabungan ST010",
                5.85,
                24,
                LocalDate.of(2027, 1, 1),
                75000
        ));

        nationalGovermentSecuritiesList.add(new NationalGovermentSecurities(
                "SBN003",
                "SBN Ritel SR018",
                6.25,
                36,
                LocalDate.of(2028, 8, 20),
                125000
        ));
    }

    public List<NationalGovermentSecurities> findAll() {
        return this.nationalGovermentSecuritiesList;
    }

    public NationalGovermentSecurities findByCode(String code) {
        for (NationalGovermentSecurities nationalGovermentSecurities : nationalGovermentSecuritiesList) {
            if (nationalGovermentSecurities.getCode().equalsIgnoreCase(code)) {
                return nationalGovermentSecurities;
            }
        }
        return null;
    }
}