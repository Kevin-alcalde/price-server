package com.gft.inditext.pricing_server.domain.entity;

import com.gft.inditext.pricing_server.domain.valueobject.*;
import com.gft.inditext.pricing_server.domain.valueobject.date.EndDate;
import com.gft.inditext.pricing_server.domain.valueobject.date.StartDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductPriceTest {

    @Test
    void givenValidParameters_whenConstructorIsCalled_thenReturnsProductPrice() {
        // Given
        final BrandId brandId = new BrandId(21321L);
        final StartDate startDate = new StartDate("2020-06-14T10:00:00");
        final EndDate endDate = new EndDate("2020-06-14T10:00:00");
        final PriceList priceList = new PriceList(1);
        final ProductId productId = new ProductId(213);
        final Priority priority = new Priority(10);
        final Price price = new Price(35.50);
        final Currency currency = new Currency("EUR");

        // When
        final ProductPrice productPrice = new ProductPrice(
                brandId,
                startDate,
                endDate,
                priceList,
                productId,
                priority,
                price,
                currency
        );

        // Then
        Assertions.assertNotNull(productPrice);
    }

    @Test
    void givenValidParameters_whenBuilderIsUsed_thenReturnsProductPrice() {
        // Given
        final BrandId brandId = new BrandId(21321L);
        final StartDate startDate = new StartDate("2020-06-14T10:00:00");
        final EndDate endDate = new EndDate("2020-06-14T10:00:00");
        final PriceList priceList = new PriceList(1);
        final ProductId productId = new ProductId(213);
        final Priority priority = new Priority(10);
        final Price price = new Price(35.50);
        final Currency currency = new Currency("EUR");

        // When
        final ProductPrice productPrice = ProductPrice.builder()
                .brandId(brandId.value())
                .startDate(startDate.value().toString())
                .endDate(endDate.value().toString())
                .price(priceList.value())
                .productId(productId.value())
                .price(price.value())
                .priority(priority.value())
                .currency(currency.value())
                .build();

        // Then
        Assertions.assertNotNull(productPrice);
    }

}