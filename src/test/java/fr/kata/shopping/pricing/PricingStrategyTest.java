package fr.kata.shopping.pricing;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static fr.kata.shopping.product.Product.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingStrategyTest {

    @Test
    void testIndividualPricing() {
        PricingStrategy strategy = new IndividualPricingStrategy();
        assertEquals(BigDecimal.valueOf(1500), strategy.getPrice(TELEPHONE_HAUT_GAMME));
        assertEquals(BigDecimal.valueOf(800), strategy.getPrice(TELEPHONE_MOYEN_GAMME));
        assertEquals(BigDecimal.valueOf(1200), strategy.getPrice(ORDINATEUR_PORTABLE));
    }

    @Test
    void testProfessionalHighRevenuePricing() {
        PricingStrategy strategy = new ProfessionalHighRevenuePricingStrategy();
        assertEquals(BigDecimal.valueOf(1000), strategy.getPrice(TELEPHONE_HAUT_GAMME));
        assertEquals(BigDecimal.valueOf(550), strategy.getPrice(TELEPHONE_MOYEN_GAMME));
        assertEquals(BigDecimal.valueOf(900), strategy.getPrice(ORDINATEUR_PORTABLE));
    }

    @Test
    void testProfessionalLowRevenuePricing() {
        PricingStrategy strategy = new ProfessionalLowRevenuePricingStrategy();
        assertEquals(BigDecimal.valueOf(1150), strategy.getPrice(TELEPHONE_HAUT_GAMME));
        assertEquals(BigDecimal.valueOf(600), strategy.getPrice(TELEPHONE_MOYEN_GAMME));
        assertEquals(BigDecimal.valueOf(1000), strategy.getPrice(ORDINATEUR_PORTABLE));
    }

}