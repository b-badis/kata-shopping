package fr.kata.shopping.client;

import fr.kata.shopping.pricing.PricingStrategy;
import fr.kata.shopping.pricing.ProfessionalHighRevenuePricingStrategy;
import fr.kata.shopping.pricing.ProfessionalLowRevenuePricingStrategy;

import java.math.BigDecimal;

public class ClientFactory {
    public static Client createIndividualClient(String id, String firstName, String lastName) {
        return new IndividualClient(id, firstName, lastName);
    }

    public static Client createProfessionalClient(String id, String companyName, String tvaNumber, String siren, BigDecimal revenue) {
        PricingStrategy strategy = revenue.compareTo(BigDecimal.valueOf(10_000_000))>0
                ? new ProfessionalHighRevenuePricingStrategy()
                : new ProfessionalLowRevenuePricingStrategy();
        return new ProfessionalClient(id, companyName, tvaNumber, siren, revenue,strategy);
    }
}
