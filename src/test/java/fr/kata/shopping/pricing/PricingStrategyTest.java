package fr.kata.shopping.pricing;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PricingStrategyTest {
    @Test
    void testPricingStrategyInterface() {
        PricingStrategy strategy = productType -> BigDecimal.valueOf(1000); // Implémentation fictive pour tester l'interface
        assertEquals(BigDecimal.valueOf(1000), strategy.getPrice("TELEPHONE_HAUT_GAMME"));
    }
}