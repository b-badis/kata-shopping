package fr.kata.shopping.client.professional;

public record TvaNumber(String value) {
    public static TvaNumber of(String value) {
        return new TvaNumber(value);
    }

    @Override
    public String toString() {
        return value;
    }
}