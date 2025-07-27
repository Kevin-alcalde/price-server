package com.gft.inditext.pricing_server.application.product.request;

public record PriceRequest(String date,
                           Integer productId,
                           Long brandId) {
}
