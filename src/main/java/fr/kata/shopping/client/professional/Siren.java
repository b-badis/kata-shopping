package fr.kata.shopping.client.professional;

import fr.kata.shopping.exception.DataValidationException;

public record Siren(String value) {
    public Siren {
        if (value == null || value.isBlank()) {
            throw new DataValidationException("Siren cannot be null or empty");
        }
    }

    public static Siren of(String value) {
        return new Siren(value);
    }

    @Override
    public String toString() {
        return value;
    }
}