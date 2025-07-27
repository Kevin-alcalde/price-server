package com.gft.inditext.pricing_server.domain.ddto;

import com.gft.inditext.pricing_server.domain.valueobject.BrandId;
import com.gft.inditext.pricing_server.domain.valueobject.ProductId;
import com.gft.inditext.pricing_server.domain.valueobject.date.DateRequested;

public record ProductPriceDDto(DateRequested dateRequested,
                               ProductId productId,
                               BrandId brandId) {
}
