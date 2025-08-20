package com.gft.inditext.pricing_server.domain.util;

import com.gft.inditext.pricing_server.domain.exception.EmptyValueException;
import com.gft.inditext.pricing_server.domain.exception.NegativeValueException;
import com.gft.inditext.pricing_server.domain.exception.NullValueException;

public class IntegerUtil {

    private IntegerUtil() {
        // Utility class should not be instantiated
    }

    public static void checkIsNotEmpty(final Integer value, final String className) {
        if (value == null) {
            throw EmptyValueException.create(className);
        }
    }

    public static void checkIsNotNull(final Integer value, final String className) {
        if (value == null) {
            throw NullValueException.createWithDefaultMessage(className);
        }
    }

    public static void checkIsNotNegative(final Integer value, final String className) {
        if (value != null && value < 0) {
            throw NegativeValueException.create(className);
        }
    }
}
