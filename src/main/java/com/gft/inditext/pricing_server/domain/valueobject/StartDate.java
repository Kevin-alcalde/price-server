package com.gft.inditext.pricing_server.domain.valueobject;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public final class StartDate implements ValueObject<LocalDateTime> {

    private final LocalDateTime date;
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public StartDate(final String value) {
        validateDateFormat(value);
        this.date = LocalDateTime.parse(value, ISO_FORMATTER);
    }

    private void validateDateFormat(final String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha no puede ser nula o vacía");
        }
        try {
            LocalDateTime.parse(value, ISO_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Use: yyyy-MM-dd HH:mm:ss");
        }
    }

    public LocalDateTime value() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartDate that = (StartDate) o;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return date.format(ISO_FORMATTER);
    }

}