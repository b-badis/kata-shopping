package fr.kata.shopping.client.individual;

import fr.kata.shopping.client.ClientId;
import fr.kata.shopping.exception.DataValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ClientIdTest {

    @Test
    void shouldCreateClientIdWhenValueIsValid() {
        ClientId clientId = new ClientId("valid-id");
        assertEquals("valid-id", clientId.value());
    }

    @ParameterizedTest
    @CsvSource({
            "null",
            "''",
            "'   '"
    })
    void shouldThrowExceptionForInvalidValues(String value) {
        DataValidationException exception = assertThrows(DataValidationException.class, () -> new ClientId(value));
        assertEquals("Client ID cannot be null or empty", exception.getMessage());
    }

    @Test
    void shouldBeEqualWhenValuesAreTheSame() {
        ClientId clientId1 = new ClientId("same-id");
        ClientId clientId2 = new ClientId("same-id");
        assertEquals(clientId1, clientId2);
        assertEquals(clientId1.hashCode(), clientId2.hashCode());
    }

    @Test
    void shouldNotBeEqualWhenValuesAreDifferent() {
        ClientId clientId1 = new ClientId("id-1");
        ClientId clientId2 = new ClientId("id-2");
        assertNotEquals(clientId1, clientId2);
    }

    @Test
    void shouldReturnStringRepresentationOfValue() {
        ClientId clientId = new ClientId("string-id");
        assertEquals("string-id", clientId.toString());
    }
}