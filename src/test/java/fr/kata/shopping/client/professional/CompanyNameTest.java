package fr.kata.shopping.client.professional;

import fr.kata.shopping.client.ClientId;
import fr.kata.shopping.exception.DataValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CompanyNameTest {

    @Test
    void shouldCreateCompanyNameWhenValueIsValid() {
        CompanyName companyName = new CompanyName("Valid Company");
        assertEquals("Valid Company", companyName.value());
    }

    @ParameterizedTest
    @CsvSource({
            "null",
            "''",
            "'   '"
    })
    void shouldThrowExceptionForInvalidValues(String value) {
        DataValidationException exception = assertThrows(DataValidationException.class, () -> new ClientId(value));
        assertEquals("CompanyName cannot be null or empty", exception.getMessage());
    }

    @Test
    void shouldReturnStringRepresentationOfValue() {
        CompanyName companyName = new CompanyName("Test Company");
        assertEquals("Test Company", companyName.toString());
    }

    @Test
    void shouldCreateCompanyNameUsingFactoryMethod() {
        CompanyName companyName = CompanyName.of("Factory Company");
        assertEquals("Factory Company", companyName.value());
    }
}