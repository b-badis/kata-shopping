package fr.kata.shopping.client;

import static fr.kata.shopping.product.Product.*;
import static org.junit.jupiter.api.Assertions.*;

import fr.kata.shopping.pricing.IndividualPricingStrategy;
import fr.kata.shopping.pricing.PricingStrategy;
import fr.kata.shopping.product.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class IndividualClientTest {

    @Test
    void testCreateIndividualClient() {
        IndividualClient client = new IndividualClient("C123", "Jean", "Dupont");

        assertNotNull(client);
        assertEquals("C123", client.getId());
        assertEquals("Jean", client.getFirstName());
        assertEquals("Dupont", client.getLastName());
        assertTrue(client.getPricingStrategy() instanceof IndividualPricingStrategy);
    }

    @Test
    void testPricingStrategyApplication() {
        IndividualClient client = new IndividualClient("C456", "Alice", "Martin");
        PricingStrategy strategy = client.getPricingStrategy();

        assertEquals(BigDecimal.valueOf(1500), strategy.getPrice(TELEPHONE_HAUT_GAMME));
        assertEquals(BigDecimal.valueOf(800), strategy.getPrice(TELEPHONE_MOYEN_GAMME));
        assertEquals(BigDecimal.valueOf(1200), strategy.getPrice(ORDINATEUR_PORTABLE));
    }
}
