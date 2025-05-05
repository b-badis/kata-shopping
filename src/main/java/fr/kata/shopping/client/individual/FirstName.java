package fr.kata.shopping.client.individual;

import fr.kata.shopping.exception.DataValidationException;

public record FirstName(String value) {
    public FirstName {
        if (value == null || value.isBlank()) {
            throw new DataValidationException("FirstName cannot be null or empty");
        }
    }

    public static FirstName of(String value) {
        return new FirstName(value);
    }

    @Override
    public String toString() {
        return value;
    }
}