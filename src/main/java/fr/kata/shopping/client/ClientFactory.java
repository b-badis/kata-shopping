package fr.kata.shopping.client;

import fr.kata.shopping.client.individual.FirstName;
import fr.kata.shopping.client.individual.IndividualClient;
import fr.kata.shopping.client.individual.LastName;
import fr.kata.shopping.client.professional.*;
import fr.kata.shopping.pricing.PricingStrategy;
import fr.kata.shopping.pricing.ProfessionalHighRevenuePricingStrategy;
import fr.kata.shopping.pricing.ProfessionalLowRevenuePricingStrategy;

import java.math.BigDecimal;

public class ClientFactory {
    private ClientFactory() {
        // Private constructor to prevent instantiation
    }
    public static Client createIndividualClient(ClientId id, FirstName firstName, LastName lastName) {
        return new IndividualClient(id, firstName, lastName);
    }

    public static Client createProfessionalClient(ClientId id, CompanyName companyName, TvaNumber tvaNumber, Siren siren, Revenue revenue) {
        PricingStrategy strategy = revenue.compareTo(BigDecimal.valueOf(10_000_000))>0
                ? new ProfessionalHighRevenuePricingStrategy()
                : new ProfessionalLowRevenuePricingStrategy();
        return new ProfessionalClient(id, companyName, tvaNumber, siren, revenue,strategy);
    }
}
