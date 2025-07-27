package com.gft.inditext.pricing_server.domain.valueobject.date;

import com.gft.inditext.pricing_server.domain.util.DateTimeUtil;
import com.gft.inditext.pricing_server.domain.util.ObjectUtil;
import com.gft.inditext.pricing_server.domain.valueobject.ValueObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class AbstractDateValueObject implements ValueObject<LocalDateTime> {

    protected static final DateTimeFormatter ISO_FORMATTER =
            DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private static final String CLASS_NAME =
            AbstractDateValueObject.class.getSimpleName();

    private final LocalDateTime date;

    protected AbstractDateValueObject(String value) {
        validate(value);
        this.date = parse(value);
    }

    private static void validate(String value) {
        ObjectUtil.checkNonNull(value, CLASS_NAME);
        ObjectUtil.checkNotEmpty(value, CLASS_NAME);
        DateTimeUtil.formatDate(value, CLASS_NAME);
    }

    private static LocalDateTime parse(String value) {
        return LocalDateTime.parse(value, ISO_FORMATTER);
    }

    @Override
    public LocalDateTime value() {
        return date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public boolean equals(Object o) {
        return this == o ||
                (o instanceof AbstractDateValueObject other
                        && Objects.equals(date, other.date));
    }

    @Override
    public String toString() {
        return date.format(ISO_FORMATTER);
    }

}
