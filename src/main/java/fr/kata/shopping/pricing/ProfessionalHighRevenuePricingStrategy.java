package fr.kata.shopping.pricing;

import java.math.BigDecimal;

public class ProfessionalHighRevenuePricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal getPrice(String productType) {
        return switch (productType) {
            case "TELEPHONE_HAUT_GAMME" -> BigDecimal.valueOf(1000);
            case "TELEPHONE_MOYEN_GAMME" -> BigDecimal.valueOf(550);
            case "ORDINATEUR_PORTABLE" -> BigDecimal.valueOf(900);
            default -> throw new IllegalArgumentException("Produit inconnu");
        };
    }
}
