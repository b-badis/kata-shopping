package fr.kata.shopping.client;

import fr.kata.shopping.pricing.PricingStrategy;

public interface Client {
    String getId();

    PricingStrategy getPricingStrategy();
}
