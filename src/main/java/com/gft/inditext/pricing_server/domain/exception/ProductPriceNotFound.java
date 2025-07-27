package com.gft.inditext.pricing_server.domain.exception;

import java.io.Serial;

public class ProductPriceNotFound extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 43244234223442344L;

    private static final String DEFAULT_MESSAGE = "Product Price Not Found with Product Id [%s] and Requested Date [%s]";

    public ProductPriceNotFound(final String message) {
        super(message);
    }

    public static ProductPriceNotFound create(final String productId, final String requestedDate) {
        return new ProductPriceNotFound(DEFAULT_MESSAGE.formatted(productId, requestedDate));
    }

}
