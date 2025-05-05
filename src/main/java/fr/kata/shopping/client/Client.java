package fr.kata.shopping.client;

import fr.kata.shopping.pricing.PricingStrategy;

public interface Client {
    ClientId id();

    PricingStrategy pricingStrategy();
}
