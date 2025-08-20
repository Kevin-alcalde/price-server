package com.gft.inditext.pricing_server.domain.service;

import com.gft.inditext.pricing_server.domain.ddto.ProductPriceDDto;
import com.gft.inditext.pricing_server.domain.entity.ProductPrice;
import com.gft.inditext.pricing_server.domain.repository.ProductPriceRepository;
import com.gft.inditext.pricing_server.domain.valueobject.*;
import com.gft.inditext.pricing_server.domain.valueobject.date.DateRequested;
import com.gft.inditext.pricing_server.domain.valueobject.date.EndDate;
import com.gft.inditext.pricing_server.domain.valueobject.date.StartDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class PriceFinderTest {

    @InjectMocks
    PriceFinder priceFinder;
    @Mock
    ProductPriceRepository productPriceRepository;

    @Test
    void givenProductPriceDDto_whenFindPrice_thenReturnsProductPrice() {
        // Given
        final DateRequested dateRequested = new DateRequested("2020-06-14T21:00:00");
        final ProductId productId = new ProductId(123);
        final BrandId brandId = new BrandId(212L);
        final ProductPriceDDto productPriceDDto = new ProductPriceDDto(dateRequested, productId, brandId);
        final StartDate startDate = new StartDate("2020-06-14T21:00:00");
        final EndDate endDate = new EndDate("2020-06-14T21:00:00");
        final PriceList priceList = new PriceList(1);
        final Priority priority = new Priority(1);
        final Price price = new Price(new BigDecimal("35.50"));
        final Currency currency = new Currency("USD");
        final ProductPrice productPrice = new ProductPrice(brandId, startDate, endDate, priceList, productId, priority, price, currency);

        Mockito.when(productPriceRepository.getProductPrice(Mockito.any())).thenReturn(Optional.of(productPrice));

        // When
        final ProductPrice productPriceResult = priceFinder.execute(productPriceDDto);

        // Then
        Assertions.assertNotNull(productPriceResult);
        Assertions.assertEquals(productPriceDDto.productId().value(), productPriceResult.productId());
        Assertions.assertEquals(productPriceDDto.brandId().value(), productPriceResult.brandId());
        Assertions.assertEquals(productPriceDDto.dateRequested().value().toString(), productPriceResult.startDate());
    }

}