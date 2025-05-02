package fr.kata.shopping.product;

import java.math.BigDecimal;

public enum Product {
    TELEPHONE_HAUT_GAMME(BigDecimal.valueOf(1500), BigDecimal.valueOf(1000), BigDecimal.valueOf(1150)),
    TELEPHONE_MOYEN_GAMME(BigDecimal.valueOf(800), BigDecimal.valueOf(550), BigDecimal.valueOf(600)),
    ORDINATEUR_PORTABLE(BigDecimal.valueOf(1200), BigDecimal.valueOf(900), BigDecimal.valueOf(1000));
    private final BigDecimal individualPrice;
    private final BigDecimal professionalHighRevenuePrice;
    private final BigDecimal professionalLowRevenuePrice;

    Product(BigDecimal individualPrice, BigDecimal professionalHighRevenuePrice, BigDecimal professionalLowRevenuePrice) {
        this.individualPrice = individualPrice;
        this.professionalHighRevenuePrice = professionalHighRevenuePrice;
        this.professionalLowRevenuePrice = professionalLowRevenuePrice;
    }

    public BigDecimal getIndividualPrice() {
        return individualPrice;
    }

    public BigDecimal getProfessionalHighRevenuePrice() {
        return professionalHighRevenuePrice;
    }

    public BigDecimal getProfessionalLowRevenuePrice() {
        return professionalLowRevenuePrice;
    }
}
