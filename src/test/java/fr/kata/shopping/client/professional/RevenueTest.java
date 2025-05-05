package fr.kata.shopping.client.professional;

import fr.kata.shopping.exception.DataValidationException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RevenueTest {

    @Test
    void shouldCreateRevenueWhenValueIsValid() {
        Revenue revenue = new Revenue(BigDecimal.valueOf(10000));
        assertEquals(BigDecimal.valueOf(10000), revenue.value());
    }

    @Test
    void shouldThrowExceptionWhenValueIsNull() {
        DataValidationException exception = assertThrows(DataValidationException.class, () -> Revenue.of(null));
        assertEquals("Revenue cannot be null or bellow 0", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenValueIsNegative() {
        DataValidationException exception = assertThrows(DataValidationException.class, () -> Revenue.of(-1L));
        assertEquals("Revenue cannot be null or bellow 0", exception.getMessage());
    }

    @Test
    void shouldCreateRevenueUsingFactoryMethodWithBigDecimal() {
        Revenue revenue = Revenue.of(BigDecimal.valueOf(5000));
        assertEquals(BigDecimal.valueOf(5000), revenue.value());
    }

    @Test
    void shouldCreateRevenueUsingFactoryMethodWithLong() {
        Revenue revenue = Revenue.of(2000L);
        assertEquals(BigDecimal.valueOf(2000), revenue.value());
    }

    @Test
    void shouldReturnStringRepresentationOfValue() {
        Revenue revenue = new Revenue(BigDecimal.valueOf(15000));
        assertEquals("15000", revenue.toString());
    }

    @Test
    void shouldCompareRevenueWithBigDecimal() {
        Revenue revenue = new Revenue(BigDecimal.valueOf(10000));
        assertTrue(revenue.compareTo(BigDecimal.valueOf(5000)) > 0);
        assertEquals(0, revenue.compareTo(BigDecimal.valueOf(10000)));
        assertTrue(revenue.compareTo(BigDecimal.valueOf(15000)) < 0);
    }
}