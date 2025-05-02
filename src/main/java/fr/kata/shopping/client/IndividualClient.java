package fr.kata.shopping.client;

import fr.kata.shopping.pricing.IndividualPricingStrategy;
import fr.kata.shopping.pricing.PricingStrategy;

public class IndividualClient implements Client {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final PricingStrategy pricingStrategy;

    public IndividualClient(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pricingStrategy = new IndividualPricingStrategy();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
