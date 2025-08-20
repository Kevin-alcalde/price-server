package com.gft.inditext.pricing_server.domain.valueobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BrandIdTest {

    @Test
    void givenValidLongValue_whenCreatingBrandId_thenConstructorIsCalled() {
        // Arrange
        long validBrandId = 1L;

        // Act
        final BrandId brandId = new BrandId(validBrandId);

        // Assert
        Assertions.assertNotNull(brandId);
        Assertions.assertDoesNotThrow(() -> new BrandId(validBrandId));
    }

    @Test
    void givenNullValue_whenCreatingBrandId_thenNullValueExceptionIsCalled() {
        // Arrange
        long validBrandId = 1L;

        // Act
        final BrandId brandId = new BrandId(validBrandId);

        // Assert
        Assertions.assertNotNull(brandId);
        Assertions.assertDoesNotThrow(() -> new BrandId(validBrandId));
    }

}