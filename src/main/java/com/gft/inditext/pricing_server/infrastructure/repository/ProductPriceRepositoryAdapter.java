package com.gft.inditext.pricing_server.infrastructure.repository;

import com.gft.inditext.pricing_server.application.mapper.ProductPriceMapper;
import com.gft.inditext.pricing_server.application.model.JpaProductPrice;
import com.gft.inditext.pricing_server.domain.dto.ProductPriceDDto;
import com.gft.inditext.pricing_server.domain.entity.ProductPrice;
import com.gft.inditext.pricing_server.domain.repository.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductPriceRepositoryAdapter implements ProductPriceRepository {

    private final JpaProductPriceRepository jpaProductPriceRepository;

    @Override
    public Optional<ProductPrice> getProductPrice(ProductPriceDDto productPriceDDto) {
        final long brandId = productPriceDDto.brandId().value();
        final int productId = productPriceDDto.productId().value();
        final LocalDateTime requestedDate = productPriceDDto.dateRequested().value();
        final Optional<JpaProductPrice> productPrice = jpaProductPriceRepository.getProductPrice(brandId, productId, requestedDate);
        return productPrice.map(
                ProductPriceMapper::toEntity
        );
    }

}
