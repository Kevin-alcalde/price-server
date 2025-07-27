package com.gft.inditext.pricing_server.domain.util;

import com.gft.inditext.pricing_server.domain.exception.EmptyValue;
import com.gft.inditext.pricing_server.domain.exception.NullValue;

public class StringUtil {

    private StringUtil() {
        // Avoids class instantiation
    }

    public static void checkIsNotEmpty(final String value, final String fieldName) {
        if (value == null || value.isBlank()) {
            throw EmptyValue.create(fieldName);
        }
    }

    public static void checkIsNotNull(final String value, final String fieldName) {
        if (value == null) {
            throw NullValue.createWithDefaultMessage(fieldName);
        }
    }

}
