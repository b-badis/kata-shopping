package fr.kata.shopping.pricing;

import fr.kata.shopping.product.Product;

import java.math.BigDecimal;

public class ProfessionalLowRevenuePricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal getPrice(Product product) {
        return product.getProfessionalLowRevenuePrice();
    }
}
