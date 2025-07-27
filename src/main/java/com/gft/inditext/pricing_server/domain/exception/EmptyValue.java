package com.gft.inditext.pricing_server.domain.exception;

import java.io.Serial;

public class EmptyValue extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 43244234223442344L;

    private static final String DEFAULT_MESSAGE = "Value %s cannot be empty.";

    public EmptyValue(final String message) {
        super(message);
    }

    public static EmptyValue create(final String fieldName) {
        return new EmptyValue(DEFAULT_MESSAGE.formatted(fieldName));
    }

}
