package fr.kata.shopping.client.professional;

import fr.kata.shopping.exception.DataValidationException;

public record CompanyName(String value) {
    public CompanyName {
        if (value == null || value.isBlank()) {
            throw new DataValidationException("CompanyName cannot be null or empty");
        }
    }

    public static CompanyName of(String value) {
        return new CompanyName(value);
    }

    @Override
    public String toString() {
        return value;
    }
}