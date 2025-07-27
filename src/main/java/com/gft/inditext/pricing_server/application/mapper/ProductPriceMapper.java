package com.gft.inditext.pricing_server.application.mapper;

import com.gft.inditext.pricing_server.application.model.JpaProductPrice;
import com.gft.inditext.pricing_server.application.product.request.PriceRequest;
import com.gft.inditext.pricing_server.application.product.response.PriceResponse;
import com.gft.inditext.pricing_server.domain.ddto.ProductPriceDDto;
import com.gft.inditext.pricing_server.domain.entity.ProductPrice;
import com.gft.inditext.pricing_server.domain.valueobject.BrandId;
import com.gft.inditext.pricing_server.domain.valueobject.ProductId;
import com.gft.inditext.pricing_server.domain.valueobject.date.DateRequested;

public class ProductPriceMapper {

    private ProductPriceMapper() {
        // Avoids class instantiation
    }

    public static ProductPriceDDto toDto(final PriceRequest request) {
        final String dateRequestedValue = request.date();
        final Integer productIdValue = request.productId();
        final Long brandIdValue = request.brandId();
        final DateRequested dateRequested = new DateRequested(dateRequestedValue);
        final ProductId productId = new ProductId(productIdValue);
        final BrandId brandId = new BrandId(brandIdValue);
        return new ProductPriceDDto(dateRequested, productId, brandId);
    }

    public static ProductPrice toEntity(final JpaProductPrice jpaProductPrice) {
        return ProductPrice.builder()
                .brandId(jpaProductPrice.getBrandId())
                .startDate(jpaProductPrice.getStartDate().toString())
                .endDate(jpaProductPrice.getEndDate().toString())
                .priority(jpaProductPrice.getPriority())
                .price(jpaProductPrice.getPrice())
                .currency(jpaProductPrice.getCurrency())
                .productId(jpaProductPrice.getProductId())
                .priceList(jpaProductPrice.getPriceList())
                .build();
    }

    public static PriceResponse toResponse(final ProductPrice productPrice) {
        final int productId = productPrice.productId();
        final long brandId = productPrice.brandId();
        final int rateId = productPrice.priceList();
        final String startDate = productPrice.startDate();
        final String endDate = productPrice.endDate();
        final Number price = productPrice.price();
        return new PriceResponse(
                productId,
                brandId,
                rateId,
                startDate,
                endDate,
                price
        );
    }

}
