package fr.kata.shopping.client.professional;

import fr.kata.shopping.exception.DataValidationException;

import java.math.BigDecimal;

public record Revenue(BigDecimal value) {
    public Revenue {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new DataValidationException("Revenue cannot be null or bellow 0");
        }
    }

    public static Revenue of(BigDecimal value) {
        return new Revenue(value);
    }
    public static Revenue of(long value) {
        return of(BigDecimal.valueOf(value));
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public int compareTo(BigDecimal bigDecimal) {
        return value.compareTo(bigDecimal);
    }
}