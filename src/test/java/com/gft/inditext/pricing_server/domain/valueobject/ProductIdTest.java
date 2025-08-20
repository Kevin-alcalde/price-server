package com.gft.inditext.pricing_server.domain.valueobject;

import com.gft.inditext.pricing_server.domain.exception.NegativeValueException;
import com.gft.inditext.pricing_server.domain.exception.NullValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductIdTest {

    @Test
    void givenValidProductIdValue_whenConstructorIsCalled_thenProductIdIsCreated() {
        // Arrange
        Integer validProductIdValue = 12345;

        // Act
        ProductId productId = new ProductId(validProductIdValue);

        // Assert
        Assertions.assertNotNull(productId);
        Assertions.assertDoesNotThrow(() -> new ProductId(validProductIdValue));
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenNullValueExceptionIsThrows() {
        // Arrange
        Integer nullProductIdValue = null;

        // Act & Assert
        Assertions.assertThrows(NullValueException.class, () -> new ProductId(nullProductIdValue));
    }

    @Test
    void givenEmptyValue_whenConstructorIsCalled_thenNegativeValueExceptionIsThrows() {
        // Arrange
        Integer negativeProductIdValue = -1;

        // Act & Assert
        Assertions.assertThrows(NegativeValueException.class, () -> new ProductId(negativeProductIdValue));
    }

    @Test
    void givenNegativeValue_whenConstructorIsCalled_thenNullValueExceptionIsThrows() {
        // Arrange
        Integer negativeProductIdValue = -1;

        // Act & Assert
        Assertions.assertThrows(NegativeValueException.class, () -> new ProductId(negativeProductIdValue));
    }

}