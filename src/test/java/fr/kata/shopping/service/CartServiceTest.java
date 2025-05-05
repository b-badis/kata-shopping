package fr.kata.shopping.service;

import fr.kata.shopping.client.Client;
import fr.kata.shopping.client.ClientFactory;
import fr.kata.shopping.client.ClientId;
import fr.kata.shopping.client.individual.FirstName;
import fr.kata.shopping.client.individual.LastName;
import fr.kata.shopping.client.professional.CompanyName;
import fr.kata.shopping.client.professional.Revenue;
import fr.kata.shopping.client.professional.Siren;
import fr.kata.shopping.client.professional.TvaNumber;
import fr.kata.shopping.product.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartServiceTest {

    @Test
    void testCalculateCartTotalForIndividualClient() {
        Client client = ClientFactory.createIndividualClient(ClientId.of("C123"), FirstName.of("Jean"), LastName.of("Dupont"));
        CartService cartService = new CartService();

        Map<Product, Integer> cart = Map.of(
                Product.TELEPHONE_HAUT_GAMME, 2,
                Product.TELEPHONE_MOYEN_GAMME, 3,
                Product.ORDINATEUR_PORTABLE, 1
        );

        BigDecimal expectedTotal = new BigDecimal(1500).multiply(new BigDecimal(2))
                .add(new BigDecimal(800).multiply(new BigDecimal(3)))
                .add(new BigDecimal(1200).multiply(new BigDecimal(1)));

        assertEquals(expectedTotal, cartService.calculateTotal(client, cart));
    }

    @Test
    void testCalculateCartTotalForProfessionalClientHighRevenue() {
        Client client = ClientFactory.createProfessionalClient(ClientId.of("P456"), CompanyName.of("TechCorp"), TvaNumber.of("FR123456789"), Siren.of("123456789"), Revenue.of(15_000_000));
        CartService cartService = new CartService();

        Map<Product, Integer> cart = Map.of(
                Product.TELEPHONE_HAUT_GAMME, 2,
                Product.TELEPHONE_MOYEN_GAMME, 3,
                Product.ORDINATEUR_PORTABLE, 1
        );

        BigDecimal expectedTotal = new BigDecimal("1000").multiply(new BigDecimal(2))
                .add(new BigDecimal(550).multiply(new BigDecimal(3)))
                .add(new BigDecimal(900).multiply(new BigDecimal(1)));

        assertEquals(expectedTotal, cartService.calculateTotal(client, cart));
    }

    @Test
    void testCalculateCartTotalForProfessionalClientLowRevenue() {
        Client client = ClientFactory.createProfessionalClient(ClientId.of("P789"), CompanyName.of("StartupX"), null, Siren.of("987654321"), Revenue.of(5_000_000));
        CartService cartService = new CartService();

        Map<Product, Integer> cart = Map.of(
                Product.TELEPHONE_HAUT_GAMME, 2,
                Product.TELEPHONE_MOYEN_GAMME, 3,
                Product.ORDINATEUR_PORTABLE, 1
        );

        BigDecimal expectedTotal = new BigDecimal(1150).multiply(new BigDecimal(2))
                .add(new BigDecimal(600).multiply(new BigDecimal(3)))
                .add(new BigDecimal(1000).multiply(new BigDecimal(1)));

        assertEquals(expectedTotal, cartService.calculateTotal(client, cart));
    }

    @Test
    void testCalculateCartTotalForBoundaryRevenueProfessionalClient() {
        Client client = ClientFactory.createProfessionalClient(ClientId.of("P999"), CompanyName.of("BoundaryCorp"), TvaNumber.of("FR999999999"), Siren.of("567891234"), Revenue.of(10_000_000));
        CartService cartService = new CartService();

        Map<Product, Integer> cart = Map.of(
                Product.TELEPHONE_HAUT_GAMME, 2,
                Product.TELEPHONE_MOYEN_GAMME, 3,
                Product.ORDINATEUR_PORTABLE, 1
        );

        BigDecimal expectedTotal = new BigDecimal(1150).multiply(new BigDecimal(2))
                .add(new BigDecimal(600).multiply(new BigDecimal(3)))
                .add(new BigDecimal(1000).multiply(new BigDecimal(1)));

        assertEquals(expectedTotal, cartService.calculateTotal(client, cart));
    }
}
