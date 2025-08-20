package com.gft.inditext.pricing_server.domain.exception;

import java.io.Serial;

public class NegativeValueException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 43244234223442344L;

    public static final String DEFAULT_MESSAGE = "Value %s cannot be negative";

    public NegativeValueException(final String message) {
        super(message);
    }

    public static NegativeValueException create(final String fieldName) {
        return new NegativeValueException(DEFAULT_MESSAGE.formatted(fieldName));
    }

}
