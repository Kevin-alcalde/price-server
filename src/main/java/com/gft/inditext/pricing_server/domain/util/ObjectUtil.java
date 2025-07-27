package com.gft.inditext.pricing_server.domain.util;

import com.gft.inditext.pricing_server.domain.exception.EmptyValue;
import com.gft.inditext.pricing_server.domain.exception.NullValue;

public class ObjectUtil {

    private ObjectUtil() {
        // Avoids class instantiation
    }

    public static void checkNonNull(Object object, String fieldName) {
        if (object == null) {
            throw NullValue.createWithDefaultMessage(fieldName);
        }
    }

    public static void checkNotEmpty(String value, String fieldName) {
        if (value.isEmpty()) {
            throw EmptyValue.create(fieldName);
        }
    }

}
