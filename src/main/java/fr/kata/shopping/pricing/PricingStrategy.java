package fr.kata.shopping.pricing;

import fr.kata.shopping.product.Product;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal getPrice(Product product);
}

