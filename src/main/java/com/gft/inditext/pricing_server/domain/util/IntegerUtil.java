package com.gft.inditext.pricing_server.domain.util;

import com.gft.inditext.pricing_server.domain.exception.EmptyValue;
import com.gft.inditext.pricing_server.domain.exception.NegativeValue;
import com.gft.inditext.pricing_server.domain.exception.NullValue;

public class IntegerUtil {

    private IntegerUtil() {
        // Utility class should not be instantiated
    }

    public static void checkIsNotEmpty(final Integer value, final String className) {
        if (value == null) {
            throw EmptyValue.create(className);
        }
    }

    public static void checkIsNotNull(final Integer value, final String className) {
        if (value == null) {
            throw NullValue.createWithDefaultMessage(className);
        }
    }

    public static void checkIsNotNegative(final Integer value, final String className) {
        if (value != null && value < 0) {
            throw NegativeValue.create(className);
        }
    }
}
