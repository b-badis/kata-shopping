package fr.kata.shopping.client.professional;

import fr.kata.shopping.client.ClientId;
import fr.kata.shopping.exception.DataValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SirenTest {

    @Test
    void shouldCreateSirenWhenValueIsValid() {
        Siren siren = new Siren("123456789");
        assertEquals("123456789", siren.value());
    }

    @ParameterizedTest
    @CsvSource({
            "null",
            "''",
            "'   '"
    })
    void shouldThrowExceptionForInvalidValues(String value) {
        DataValidationException exception = assertThrows(DataValidationException.class, () -> new ClientId(value));
        assertEquals("Siren cannot be null or empty", exception.getMessage());
    }

    @Test
    void shouldReturnStringRepresentationOfValue() {
        Siren siren = new Siren("987654321");
        assertEquals("987654321", siren.toString());
    }

    @Test
    void shouldCreateSirenUsingFactoryMethod() {
        Siren siren = Siren.of("123456789");
        assertEquals("123456789", siren.value());
    }
}