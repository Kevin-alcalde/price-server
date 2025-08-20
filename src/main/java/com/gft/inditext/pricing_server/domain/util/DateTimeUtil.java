package com.gft.inditext.pricing_server.domain.util;

import com.gft.inditext.pricing_server.domain.exception.InvalidDateFormatException;

import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private DateTimeUtil() {
        // Utility class should not be instantiated
    }

    private static final DateTimeFormatter ISO_FORMATTER =
            DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public static void formatDate(String date, String fieldName) {
        try {
            ISO_FORMATTER.parse(date);
        } catch (Exception e) {
            throw InvalidDateFormatException.createWithDefaultMessage(fieldName);
        }
    }
}
