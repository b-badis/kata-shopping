package fr.kata.shopping.client.individual;

import fr.kata.shopping.exception.DataValidationException;

public record LastName(String value) {
    public LastName {
        if (value == null || value.isBlank()) {
            throw new DataValidationException("LastName cannot be null or empty");
        }
    }

    public static LastName of(String value) {
        return new LastName(value);
    }

    @Override
    public String toString() {
        return value;
    }
}