package com.gft.inditext.pricing_server.domain.service;

import com.gft.inditext.pricing_server.domain.ddto.ProductPriceDDto;
import com.gft.inditext.pricing_server.domain.entity.ProductPrice;
import com.gft.inditext.pricing_server.domain.exception.ProductPriceNotFound;
import com.gft.inditext.pricing_server.domain.repository.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceFinder {

    private final ProductPriceRepository productPriceRepository;

    public ProductPrice execute(final ProductPriceDDto productPriceDDto) {
        return productPriceRepository.getProductPrice(productPriceDDto)
                .orElseThrow(() -> ProductPriceNotFound.create(
                        productPriceDDto.productId().value().toString(),
                        productPriceDDto.dateRequested().toString())
                );
    }
    
}
