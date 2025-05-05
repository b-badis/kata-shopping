package fr.kata.shopping.client;

import fr.kata.shopping.exception.DataValidationException;

public record ClientId(String value) {
    public ClientId {
        if (value == null || value.isBlank()) {
            throw new DataValidationException("Client ID cannot be null or empty");
        }
    }

    public static ClientId of(String value) {
        return new ClientId(value);
    }

    @Override
    public String toString() {
        return value;
    }
}