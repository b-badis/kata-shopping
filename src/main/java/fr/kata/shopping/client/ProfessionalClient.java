package fr.kata.shopping.client;

import fr.kata.shopping.pricing.PricingStrategy;

import java.math.BigDecimal;
import java.util.Optional;

public class ProfessionalClient implements Client {
    private final String id;
    private final String companyName;
    private final String tvaNumber;
    private final String siren;
    private final BigDecimal revenue;
    private final PricingStrategy pricingStrategy;

    public ProfessionalClient(String id, String companyName, String tvaNumber, String siren, BigDecimal revenue, PricingStrategy pricingStrategy) {
        this.id = id;
        this.companyName = companyName;
        this.tvaNumber = tvaNumber;
        this.siren = siren;
        this.revenue = revenue;
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTvaNumber() {
        return tvaNumber;
    }

    public String getSiren() {
        return siren;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }
}
