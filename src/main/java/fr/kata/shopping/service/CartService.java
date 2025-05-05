package fr.kata.shopping.service;

import fr.kata.shopping.client.Client;
import fr.kata.shopping.product.Product;

import java.math.BigDecimal;
import java.util.Map;

public class CartService {
    public BigDecimal calculateTotal(Client client, Map<Product, Integer> cart) {
        return cart.entrySet().stream()
            .map(entry -> client.pricingStrategy().getPrice(entry.getKey()).multiply(new BigDecimal(entry.getValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
