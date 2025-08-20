package com.gft.inditext.pricing_server.domain.exception;

import java.io.Serial;

public class EmptyValueException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 43244234223442344L;

    private static final String DEFAULT_MESSAGE = "Value %s cannot be empty.";

    public EmptyValueException(final String message) {
        super(message);
    }

    public static EmptyValueException create(final String fieldName) {
        return new EmptyValueException(DEFAULT_MESSAGE.formatted(fieldName));
    }

}
