package com.gft.inditext.pricing_server.domain.util;

import com.gft.inditext.pricing_server.domain.exception.EmptyValue;
import com.gft.inditext.pricing_server.domain.exception.NullValue;

public class LongUtil {

    private LongUtil() {
        // Utility class, no instantiation allowed
    }

    public static void checkIsNotEmpty(final Long value, final String className) {
        if (value == null || value <= 0) {
            throw EmptyValue.create(className);
        }
    }

    public static void checkIsNotNull(final Long value, final String className) {
        if (value == null) {
            throw NullValue.createWithDefaultMessage(className);
        }
    }

}
