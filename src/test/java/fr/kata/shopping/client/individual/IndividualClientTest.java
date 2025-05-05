package fr.kata.shopping.client.individual;

import fr.kata.shopping.client.ClientId;
import fr.kata.shopping.exception.DataValidationException;
import fr.kata.shopping.pricing.IndividualPricingStrategy;
import fr.kata.shopping.pricing.PricingStrategy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static fr.kata.shopping.product.Product.*;
import static org.junit.jupiter.api.Assertions.*;

class IndividualClientTest {

    public static final FirstName JEAN = new FirstName("Jean");
    public static final LastName DUPONT = new LastName("Dupont");
    public static final ClientId C_123 = new ClientId("C123");

    @Test
    void testCreateIndividualClient() {
        IndividualClient client = new IndividualClient(C_123, FirstName.of("Jean"), LastName.of("Dupont"));

        assertNotNull(client);
        assertEquals(C_123, client.id());
        assertEquals(FirstName.of("Jean"), client.firstName());
        assertEquals(LastName.of("Dupont"), client.lastName());
        assertInstanceOf(IndividualPricingStrategy.class, client.pricingStrategy());
    }

    @Test
    void testPricingStrategyApplication() {
        IndividualClient client = new IndividualClient(ClientId.of("C456"), FirstName.of("Alice"), LastName.of("Martin"));
        PricingStrategy strategy = client.pricingStrategy();

        assertEquals(BigDecimal.valueOf(1500), strategy.getPrice(TELEPHONE_HAUT_GAMME));
        assertEquals(BigDecimal.valueOf(800), strategy.getPrice(TELEPHONE_MOYEN_GAMME));
        assertEquals(BigDecimal.valueOf(1200), strategy.getPrice(ORDINATEUR_PORTABLE));
    }

    @Test
    void shouldCreateIndividualClientWhenAllFieldsAreValid() {
        IndividualClient client = new IndividualClient(
                C_123,
                JEAN,
                DUPONT
        );

        assertNotNull(client);
        assertEquals(C_123, client.id());
        assertEquals(JEAN, client.firstName());
        assertEquals(DUPONT, client.lastName());
        assertInstanceOf(IndividualPricingStrategy.class, client.pricingStrategy());
    }

    @Test
    void shouldThrowExceptionWhenIdIsNull() {
        DataValidationException exception = assertThrows(DataValidationException.class, () ->
                new IndividualClient(null, JEAN, DUPONT)
        );
        assertEquals("Client ID cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenFirstNameIsNull() {
        DataValidationException exception = assertThrows(DataValidationException.class, () ->
                new IndividualClient(C_123, null, DUPONT)
        );
        assertEquals("First name cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsNull() {
        DataValidationException exception = assertThrows(DataValidationException.class, () ->
                new IndividualClient(C_123, JEAN, null)
        );
        assertEquals("Last name cannot be null", exception.getMessage());
    }
}
