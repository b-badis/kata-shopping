package fr.kata.shopping.client.professional;

import fr.kata.shopping.client.ClientId;
import fr.kata.shopping.exception.DataValidationException;
import fr.kata.shopping.pricing.ProfessionalHighRevenuePricingStrategy;
import fr.kata.shopping.pricing.ProfessionalLowRevenuePricingStrategy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static fr.kata.shopping.product.Product.*;
import static org.junit.jupiter.api.Assertions.*;

class ProfessionalClientTest {

    public static final CompanyName TECH_CORP = CompanyName.of("TechCorp");
    public static final TvaNumber FR_123456789 = TvaNumber.of("FR123456789");
    public static final Siren SIREN = Siren.of("123456789");
    public static final ProfessionalLowRevenuePricingStrategy LOW_REVENUE_PRICING_STRATEGY = new ProfessionalLowRevenuePricingStrategy();
    public static final ClientId P_123 = ClientId.of("P123");
    public static final ClientId P_456 = ClientId.of("P456");
    public static final CompanyName STARTUP_X = CompanyName.of("StartupX");
    public static final TvaNumber TVA_NUMBER = TvaNumber.of("FR987654321");

    @Test
    void shouldThrowExceptionWhenIdIsNull() {
        Revenue revenue = Revenue.of(15_000_000);
        DataValidationException exception = assertThrows(DataValidationException.class, () ->
                new ProfessionalClient(null, TECH_CORP, FR_123456789,
                        SIREN, revenue, LOW_REVENUE_PRICING_STRATEGY)
        );
        assertEquals("Client ID cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCompanyNameIsNull() {
        Revenue revenue = Revenue.of(15_000_000);
        DataValidationException exception = assertThrows(DataValidationException.class, () ->
                new ProfessionalClient(P_123, null, FR_123456789,
                        SIREN, revenue, LOW_REVENUE_PRICING_STRATEGY)
        );
        assertEquals("Company name cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSirenIsNull() {
        Revenue revenue = Revenue.of(15_000_000);
        DataValidationException exception = assertThrows(DataValidationException.class, () ->
                new ProfessionalClient(P_123, TECH_CORP, FR_123456789,
                        null, revenue, LOW_REVENUE_PRICING_STRATEGY)
        );
        assertEquals("Siren cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenRevenueIsNull() {
        DataValidationException exception = assertThrows(DataValidationException.class, () ->
                new ProfessionalClient(P_123, TECH_CORP, FR_123456789,
                        SIREN, null, LOW_REVENUE_PRICING_STRATEGY)
        );
        assertEquals("Revenue cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenPricingStrategyIsNull() {
        Revenue revenue = Revenue.of(15_000_000);
        DataValidationException exception = assertThrows(DataValidationException.class, () ->
                new ProfessionalClient(P_123, TECH_CORP, FR_123456789,
                        SIREN, revenue, null)
        );
        assertEquals("Pricing strategy cannot be null", exception.getMessage());
    }

    @Test
    void shouldCreateProfessionalClientWhenAllFieldsAreValid() {
        Revenue revenue = Revenue.of(15_000_000);
        ProfessionalClient client = new ProfessionalClient(
                P_123, TECH_CORP, FR_123456789,
                SIREN, revenue, LOW_REVENUE_PRICING_STRATEGY
        );

        assertNotNull(client);
        assertEquals(P_123, client.id());
        assertEquals(TECH_CORP, client.companyName());
        assertEquals(FR_123456789, client.tvaNumber());
        assertEquals(SIREN, client.siren());
        assertEquals(revenue, client.revenue());
        assertInstanceOf(ProfessionalLowRevenuePricingStrategy.class, client.pricingStrategy());
    }

    @Test
    void testCreateProfessionalClientWithTvaNumber() {
        ProfessionalClient client = new ProfessionalClient(
                P_123, TECH_CORP, FR_123456789, SIREN,
                Revenue.of(15_000_000), LOW_REVENUE_PRICING_STRATEGY
        );

        assertEquals(P_123, client.id());
        assertEquals(TECH_CORP, client.companyName());
        assertEquals(FR_123456789, client.tvaNumber());
        assertEquals(SIREN, client.siren());
        assertEquals(Revenue.of(15_000_000), client.revenue());
        assertInstanceOf(ProfessionalLowRevenuePricingStrategy.class, client.pricingStrategy());
    }

    @Test
    void testCreateProfessionalClientWithoutTvaNumber() {
        ProfessionalClient client = new ProfessionalClient(
                P_456, STARTUP_X, null, SIREN,
                Revenue.of(5_000_000), LOW_REVENUE_PRICING_STRATEGY);

        assertEquals(P_456, client.id());
        assertEquals(STARTUP_X, client.companyName());
        assertNull(client.tvaNumber());
        assertEquals(SIREN, client.siren());
        assertEquals(Revenue.of(5_000_000), client.revenue());
    }

    @Test
    void testPricingStrategyApplication() {
        ProfessionalClient client = new ProfessionalClient(
                P_456, STARTUP_X, TVA_NUMBER,SIREN,
                Revenue.of(12_000_000), new ProfessionalHighRevenuePricingStrategy()
        );

        assertEquals(new BigDecimal(1000), client.pricingStrategy().getPrice(TELEPHONE_HAUT_GAMME));
        assertEquals(new BigDecimal(550), client.pricingStrategy().getPrice(TELEPHONE_MOYEN_GAMME));
        assertEquals(new BigDecimal(900), client.pricingStrategy().getPrice(ORDINATEUR_PORTABLE));
    }
}