package com.gft.inditext.pricing_server.domain.exception;

import java.io.Serial;

public class NullValueException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 43244234223442344L;

    private static final String DEFAULT_MESSAGE = "The %s cannot be null.";

    public NullValueException(final String message) {
        super(message);
    }

    public static NullValueException createWithDefaultMessage(final String fieldName) {
        return new NullValueException(DEFAULT_MESSAGE.formatted(fieldName));
    }

}
