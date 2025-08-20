package com.gft.inditext.pricing_server.domain.valueobject.date;

import com.gft.inditext.pricing_server.domain.exception.EmptyValueException;
import com.gft.inditext.pricing_server.domain.exception.InvalidDateFormatException;
import com.gft.inditext.pricing_server.domain.exception.NullValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateRequestedTest {

    @Test
    void givenValidDateString_whenCreateDateRequested_thenReturnDataRequestedIsCreated() {
        // Given
        final String validDate = "2020-06-14T21:00:00";

        // When
        final DateRequested result = new DateRequested(validDate);

        // Then
        assertNotNull(result);
        assertEquals(LocalDateTime.of(2020, 6, 14, 21, 0, 0), result.value());
        assertEquals(validDate, result.toString());
    }

    @Test
    void givenNullValue_whenCreateDateRequested_thenThrowsException() {
        // Given
        final String nullValue = null;

        // When
        final NullValueException exception = assertThrows(NullValueException.class,
                () -> new DateRequested(nullValue));

        // Then
        Assertions.assertNotNull(exception);
    }

    @Test
    void givenEmptyValue_whenCreateDateRequested_thenThrowsException() {
        // Given
        final String emptyValue = "";

        // When & Then
        final EmptyValueException exception = assertThrows(EmptyValueException.class,
                () -> new DateRequested(emptyValue));

        // Then
        Assertions.assertNotNull(exception);
    }

    @Test
    void givenInvalidDateFormat_whenCreateDateRequested_thenThrowsException() {
        // Given
        final String invalidDate = "invalid-date-format";

        // When
        final InvalidDateFormatException exception = assertThrows(InvalidDateFormatException.class, () -> new DateRequested(invalidDate));

        // Then
        Assertions.assertNotNull(exception);
    }
    
}