package com.gft.inditext.pricing_server.domain.util;

import com.gft.inditext.pricing_server.domain.exception.EmptyValue;
import com.gft.inditext.pricing_server.domain.exception.NegativeValue;

public class NumberUtil {

    private NumberUtil() {
        // Utility class, no instantiation allowed
    }

    public static void checkIsNotEmtpy(final Number value, final String fieldName) {
        if (value == null) {
            throw EmptyValue.create(fieldName);
        }
    }

    public static void checkIsNotNegative(final Number value, final String fieldName) {
        if (value.doubleValue() < 0) {
            throw NegativeValue.create(fieldName);
        }
    }

}
