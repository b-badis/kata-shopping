package fr.kata.shopping.client;

import fr.kata.shopping.client.individual.FirstName;
import fr.kata.shopping.client.individual.LastName;
import fr.kata.shopping.client.professional.CompanyName;
import fr.kata.shopping.client.professional.Revenue;
import fr.kata.shopping.client.professional.Siren;
import fr.kata.shopping.pricing.IndividualPricingStrategy;
import fr.kata.shopping.pricing.ProfessionalHighRevenuePricingStrategy;
import fr.kata.shopping.pricing.ProfessionalLowRevenuePricingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ClientFactoryTest {
    @Test
    void testCreateIndividualClient() {
        Client client = ClientFactory.createIndividualClient(ClientId.of("C123"), FirstName.of("Jean"), LastName.of("Dupont"));
        assertEquals(ClientId.of("C123"), client.id());
        assertInstanceOf(IndividualPricingStrategy.class, client.pricingStrategy());
    }
    @Test
    void testCreateProfessionalClientHighRevenue() {
        Client client = ClientFactory.createProfessionalClient(ClientId.of("P456"), CompanyName.of("TechCorp"), null,Siren.of("123"), Revenue.of(15_000_000));

        assertEquals(ClientId.of("P456"), client.id());
        assertInstanceOf(ProfessionalHighRevenuePricingStrategy.class, client.pricingStrategy());
    }

    @Test
    void testCreateProfessionalClientLowRevenue() {
        Client client = ClientFactory.createProfessionalClient(ClientId.of("P789"), CompanyName.of("StartUp"),null,Siren.of("123"), Revenue.of(5_000_000));

        assertEquals(ClientId.of("P789"), client.id());
        assertInstanceOf(ProfessionalLowRevenuePricingStrategy.class, client.pricingStrategy());

    }

    @Test
    void testProfessionalClientBoundaryRevenue() {
        Client client = ClientFactory.createProfessionalClient(ClientId.of("P999"), CompanyName.of("BoundaryCorp"),null, Siren.of("123"), Revenue.of(10_000_000));

        assertEquals(ClientId.of("P999"), client.id());
        assertInstanceOf(ProfessionalLowRevenuePricingStrategy.class, client.pricingStrategy());

    }
}
