package com.gft.inditext.pricing_server.domain.repository;

import com.gft.inditext.pricing_server.domain.dto.ProductPriceDDto;
import com.gft.inditext.pricing_server.domain.entity.ProductPrice;

import java.util.Optional;

public interface ProductPriceRepository {

    Optional<ProductPrice> getProductPrice(ProductPriceDDto productPriceDDto);

}
