package com.gft.inditext.pricing_server.domain.util;

import com.gft.inditext.pricing_server.domain.exception.EmptyValueException;
import com.gft.inditext.pricing_server.domain.exception.NegativeValueException;

public class NumberUtil {

    private NumberUtil() {
        // Utility class, no instantiation allowed
    }

    public static void checkIsNotEmtpy(final Number value, final String fieldName) {
        if (value == null) {
            throw EmptyValueException.create(fieldName);
        }
    }

    public static void checkIsNotNegative(final Number value, final String fieldName) {
        if (value.doubleValue() < 0) {
            throw NegativeValueException.create(fieldName);
        }
    }

}
