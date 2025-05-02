package fr.kata.shopping.pricing;

import fr.kata.shopping.product.Product;

import java.math.BigDecimal;

public class ProfessionalHighRevenuePricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal getPrice(Product product) {
        return product.getProfessionalHighRevenuePrice();
    }
}
