package fr.kata.shopping.pricing;

import java.math.BigDecimal;

public class IndividualPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal getPrice(String productType) {
        return switch (productType) {
            case "TELEPHONE_HAUT_GAMME" -> BigDecimal.valueOf(1500);
            case "TELEPHONE_MOYEN_GAMME" -> BigDecimal.valueOf(800);
            case "ORDINATEUR_PORTABLE" -> BigDecimal.valueOf(1200);
            default -> throw new IllegalArgumentException("Produit inconnu");
        };
    }
}
