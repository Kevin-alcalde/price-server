package com.gft.inditext.pricing_server.application.usecase;

import com.gft.inditext.pricing_server.application.mapper.ProductPriceMapper;
import com.gft.inditext.pricing_server.application.product.request.PriceRequest;
import com.gft.inditext.pricing_server.application.product.response.PriceResponse;
import com.gft.inditext.pricing_server.domain.dto.ProductPriceDDto;
import com.gft.inditext.pricing_server.domain.entity.ProductPrice;
import com.gft.inditext.pricing_server.domain.service.PriceFinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetProductPriceUseCase {

    private final PriceFinder priceFinder;

    public PriceResponse execute(final PriceRequest priceRequest) {
        log.debug("execute method called with priceRequest: {}", priceRequest);
        final ProductPriceDDto productPriceDDto = ProductPriceMapper.toDto(priceRequest);
        final ProductPrice productPrice = priceFinder.execute(productPriceDDto);
        return ProductPriceMapper.toResponse(productPrice);
    }


}
