package com.gft.inditext.pricing_server.application.product.response;

public record PriceResponse(int productId,
                            long bandId,
                            int priceId,
                            String startDate,
                            String endDate,
                            Number price) {
}
