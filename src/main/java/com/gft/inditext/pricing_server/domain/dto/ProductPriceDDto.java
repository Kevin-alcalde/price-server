package com.gft.inditext.pricing_server.domain.dto;

import com.gft.inditext.pricing_server.domain.valueobject.BrandId;
import com.gft.inditext.pricing_server.domain.valueobject.DateRequested;
import com.gft.inditext.pricing_server.domain.valueobject.ProductId;

public record ProductPriceDDto(DateRequested dateRequested,
                               ProductId productId,
                               BrandId brandId) {
}
