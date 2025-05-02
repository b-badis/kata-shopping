package fr.kata.shopping.pricing;

import java.math.BigDecimal;

public class ProfessionalLowRevenuePricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal getPrice(String productType) {
        return switch (productType) {
            case "TELEPHONE_HAUT_GAMME" -> BigDecimal.valueOf(1150);
            case "TELEPHONE_MOYEN_GAMME" -> BigDecimal.valueOf(600);
            case "ORDINATEUR_PORTABLE" -> BigDecimal.valueOf(1000);
            default -> throw new IllegalArgumentException("Produit inconnu");
        };
    }
}
