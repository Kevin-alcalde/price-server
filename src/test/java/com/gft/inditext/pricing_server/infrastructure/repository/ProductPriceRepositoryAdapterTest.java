package com.gft.inditext.pricing_server.infrastructure.repository;

import com.gft.inditext.pricing_server.application.model.JpaProductPrice;
import com.gft.inditext.pricing_server.domain.ddto.ProductPriceDDto;
import com.gft.inditext.pricing_server.domain.entity.ProductPrice;
import com.gft.inditext.pricing_server.domain.valueobject.BrandId;
import com.gft.inditext.pricing_server.domain.valueobject.ProductId;
import com.gft.inditext.pricing_server.domain.valueobject.date.DateRequested;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductPriceRepositoryAdapterTest {

    @InjectMocks
    ProductPriceRepositoryAdapter productPriceRepositoryAdapter;

    @Mock
    JpaProductPriceRepository jpaProductPriceRepository;

    @Test
    void givenValidProductPriceDdto_whengetProductPrice_thenReturnsOptionalProductPrice() {
        // Given
        final DateRequested date = new DateRequested("2020-06-14T21:00:00");
        final ProductId productId = new ProductId(1231);
        final BrandId brandId = new BrandId(1L);
        final ProductPriceDDto productPriceDDto = new ProductPriceDDto(date, productId, brandId);
        final JpaProductPrice japaProductPrice = new JpaProductPrice(
                1L,
                brandId.value(),
                date.value(),
                date.value(),
                1,
                productId.value(),
                10,
                new BigDecimal("35.50"),
                "EUR"
        );
        Mockito.when(jpaProductPriceRepository.getProductPrice(brandId.value(), productId.value(), date.value()))
                .thenReturn(Optional.of(japaProductPrice));

        // When
        final Optional<ProductPrice> productPrice = productPriceRepositoryAdapter.getProductPrice(productPriceDDto);

        // Then
        Assertions.assertTrue(productPrice.isPresent());
        Mockito.verify(jpaProductPriceRepository, Mockito.times(1))
                .getProductPrice(brandId.value(), productId.value(), date.value());
    }


    @Test
    void givenValidProductPriceDdto_whengetProductPrice_thenReturnsEmptyOptionalProductPrice() {
        // Given
        final DateRequested dateRequested = new DateRequested("2020-06-14T21:00:00");
        final ProductId productId = new ProductId(1231);
        final BrandId brandId = new BrandId(1L);
        final ProductPriceDDto productPriceDDto = new ProductPriceDDto(dateRequested, productId, brandId);
        Mockito.when(jpaProductPriceRepository.getProductPrice(brandId.value(), productId.value(), dateRequested.value())).thenReturn(Optional.empty());

        // When
        final Optional<ProductPrice> productPrice = productPriceRepositoryAdapter.getProductPrice(productPriceDDto);

        // Then
        Assertions.assertFalse(productPrice.isPresent());
        Mockito.verify(jpaProductPriceRepository, Mockito.times(1))
                .getProductPrice(brandId.value(), productId.value(), dateRequested.value());
    }


}