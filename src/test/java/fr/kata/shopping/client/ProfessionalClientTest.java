package fr.kata.shopping.client;

import fr.kata.shopping.pricing.ProfessionalHighRevenuePricingStrategy;
import fr.kata.shopping.pricing.ProfessionalLowRevenuePricingStrategy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static fr.kata.shopping.product.Product.*;
import static org.junit.jupiter.api.Assertions.*;

class ProfessionalClientTest {

    @Test
    void testCreateProfessionalClientWithTvaNumber() {
        ProfessionalClient client = new ProfessionalClient(
                "P123", "TechCorp", "FR123456789", "123456789",
                new BigDecimal(15_000_000), new ProfessionalLowRevenuePricingStrategy()
        );

        assertEquals("P123", client.getId());
        assertEquals("TechCorp", client.getCompanyName());
        assertEquals("FR123456789", client.getTvaNumber());
        assertEquals("123456789", client.getSiren());
        assertEquals(new BigDecimal(15_000_000), client.getRevenue());
        assertTrue(client.getPricingStrategy() instanceof ProfessionalLowRevenuePricingStrategy);
    }

    @Test
    void testCreateProfessionalClientWithoutTvaNumber() {
        ProfessionalClient client = new ProfessionalClient(
                "P456", "StartupX", null, "987654321",
                new BigDecimal(5_000_000), new ProfessionalLowRevenuePricingStrategy());

        assertEquals("P456", client.getId());
        assertEquals("StartupX", client.getCompanyName());
        assertNull(client.getTvaNumber());
        assertEquals("987654321", client.getSiren());
        assertEquals(new BigDecimal(5_000_000), client.getRevenue());
    }

    @Test
    void testPricingStrategyApplication() {
        ProfessionalClient client = new ProfessionalClient(
                "P789", "EnterpriseY", "FR987654321", "567891234",
                new BigDecimal(12_000_000), new ProfessionalHighRevenuePricingStrategy()
        );

        assertEquals(new BigDecimal(1000), client.getPricingStrategy().getPrice(TELEPHONE_HAUT_GAMME));
        assertEquals(new BigDecimal(550), client.getPricingStrategy().getPrice(TELEPHONE_MOYEN_GAMME));
        assertEquals(new BigDecimal(900), client.getPricingStrategy().getPrice(ORDINATEUR_PORTABLE));
    }
}