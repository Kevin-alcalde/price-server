package com.gft.inditext.pricing_server.domain.util;

import com.gft.inditext.pricing_server.domain.exception.EmptyValueException;
import com.gft.inditext.pricing_server.domain.exception.NullValueException;

public class ObjectUtil {

    private ObjectUtil() {
        // Avoids class instantiation
    }

    public static void checkNonNull(Object object, String fieldName) {
        if (object == null) {
            throw NullValueException.createWithDefaultMessage(fieldName);
        }
    }

    public static void checkNotEmpty(String value, String fieldName) {
        if (value.isEmpty()) {
            throw EmptyValueException.create(fieldName);
        }
    }

}
