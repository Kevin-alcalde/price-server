package com.gft.inditext.pricing_server.domain.exception;

import java.io.Serial;

public class InvalidDateFormatException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 432423334455543221L;

    private static final String DEFAULT_MESSAGE = "%s has invalid date format. Expected format is 'yyyy-MM-dd'.";

    public InvalidDateFormatException(final String message) {
        super(message);
    }

    public static InvalidDateFormatException createWithDefaultMessage(final String className) {
        return new InvalidDateFormatException(DEFAULT_MESSAGE.formatted(className));
    }

}
