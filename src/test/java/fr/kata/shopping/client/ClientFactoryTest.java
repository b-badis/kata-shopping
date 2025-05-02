package fr.kata.shopping.client;

import fr.kata.shopping.pricing.IndividualPricingStrategy;
import fr.kata.shopping.pricing.ProfessionalHighRevenuePricingStrategy;
import fr.kata.shopping.pricing.ProfessionalLowRevenuePricingStrategy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientFactoryTest {
    @Test
    void testCreateIndividualClient() {
        Client client = ClientFactory.createIndividualClient("C123", "Jean", "Dupont");
        assertEquals("C123", client.getId());
        assertTrue(client.getPricingStrategy() instanceof IndividualPricingStrategy);
    }
    @Test
    void testCreateProfessionalClientHighRevenue() {
        Client client = ClientFactory.createProfessionalClient("P456", "TechCorp", null,"123", BigDecimal.valueOf(15_000_000));

        assertEquals("P456", client.getId());
        assertTrue(client.getPricingStrategy() instanceof ProfessionalHighRevenuePricingStrategy);
    }

    @Test
    void testCreateProfessionalClientLowRevenue() {
        Client client = ClientFactory.createProfessionalClient("P789", "StartUp",null,"123", BigDecimal.valueOf(5_000_000));

        assertEquals("P789", client.getId());
        assertTrue(client.getPricingStrategy() instanceof ProfessionalLowRevenuePricingStrategy);

    }

    @Test
    void testProfessionalClientBoundaryRevenue() {
        Client client = ClientFactory.createProfessionalClient("P999", "BoundaryCorp",null,"123", BigDecimal.valueOf(10_000_000));

        assertEquals("P999", client.getId());
        assertTrue(client.getPricingStrategy() instanceof ProfessionalLowRevenuePricingStrategy);

    }
}
