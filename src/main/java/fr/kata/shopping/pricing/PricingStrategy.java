package fr.kata.shopping.pricing;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal getPrice(String productType);
}
