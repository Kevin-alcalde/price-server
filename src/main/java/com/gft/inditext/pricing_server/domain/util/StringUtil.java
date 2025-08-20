package com.gft.inditext.pricing_server.domain.util;

import com.gft.inditext.pricing_server.domain.exception.EmptyValueException;
import com.gft.inditext.pricing_server.domain.exception.NullValueException;

public class StringUtil {

    private StringUtil() {
        // Avoids class instantiation
    }

    public static void checkIsNotEmpty(final String value, final String fieldName) {
        if (value == null || value.isBlank()) {
            throw EmptyValueException.create(fieldName);
        }
    }

    public static void checkIsNotNull(final String value, final String fieldName) {
        if (value == null) {
            throw NullValueException.createWithDefaultMessage(fieldName);
        }
    }

}
