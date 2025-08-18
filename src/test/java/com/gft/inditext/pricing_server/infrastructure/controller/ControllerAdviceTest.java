package com.gft.inditext.pricing_server.infrastructure.controller;

import com.gft.inditext.pricing_server.application.product.response.FailureResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ControllerAdviceTest {

    private final ControllerAdvice controllerAdvice = new ControllerAdvice();

    @Test
    void givenValidRuntimeException_whenHandleException_thenReturnsBadRequestResponse() {
        // Given
        final String message = "Test exception";
        final RuntimeException runtimeException = new RuntimeException(message);

        // When
        final ResponseEntity<FailureResponse> responseEntity
                = controllerAdvice.handleException(runtimeException);

        // Then
        Assertions.assertNotNull(responseEntity);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Assertions.assertEquals(message, responseEntity.getBody().message());
    }

    @Test
    void givenRuntimeException_whenHandleProductPriceNotFoundException_thenReturnsNotFoundResponse() {
        // Given
        final String message = "Product price not found";
        final RuntimeException runtimeException = new RuntimeException(message);

        // When
        final ResponseEntity<FailureResponse> responseEntity
                = controllerAdvice.handleProductPriceNotFoundException(runtimeException);

        // Then
        Assertions.assertNotNull(responseEntity);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        Assertions.assertEquals(message, responseEntity.getBody().message());
    }

}