package fr.kata.shopping.client.individual;

import fr.kata.shopping.client.Client;
import fr.kata.shopping.client.ClientId;
import fr.kata.shopping.exception.DataValidationException;
import fr.kata.shopping.pricing.IndividualPricingStrategy;
import fr.kata.shopping.pricing.PricingStrategy;

public record IndividualClient(ClientId id, FirstName firstName, LastName lastName,
                               PricingStrategy pricingStrategy) implements Client {
    public IndividualClient(ClientId id, FirstName firstName, LastName lastName) {
        this(id, firstName, lastName, new IndividualPricingStrategy());
        if (id == null) {
            throw new DataValidationException("Client ID cannot be null");
        }
        if (firstName == null) {
            throw new DataValidationException("First name cannot be null");
        }
        if (lastName == null) {
            throw new DataValidationException("Last name cannot be null");
        }
    }
}