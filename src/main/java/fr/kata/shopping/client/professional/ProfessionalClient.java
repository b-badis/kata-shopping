package fr.kata.shopping.client.professional;

import fr.kata.shopping.client.Client;
import fr.kata.shopping.client.ClientId;
import fr.kata.shopping.exception.DataValidationException;
import fr.kata.shopping.pricing.PricingStrategy;

public record ProfessionalClient(ClientId id, CompanyName companyName, TvaNumber tvaNumber, Siren siren, Revenue revenue,
                                 PricingStrategy pricingStrategy) implements Client {
    public ProfessionalClient {
        if (id == null) {
            throw new DataValidationException("Client ID cannot be null");
        }
        if (companyName == null) {
            throw new DataValidationException("Company name cannot be null");
        }
        if (siren == null) {
            throw new DataValidationException("Siren cannot be null");
        }
        if (revenue == null) {
            throw new DataValidationException("Revenue cannot be null");
        }
        if (pricingStrategy == null) {
            throw new DataValidationException("Pricing strategy cannot be null");
        }
    }
}