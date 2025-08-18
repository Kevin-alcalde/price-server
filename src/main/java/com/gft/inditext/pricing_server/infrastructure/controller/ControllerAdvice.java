package com.gft.inditext.pricing_server.infrastructure.controller;

import com.gft.inditext.pricing_server.application.product.response.FailureResponse;
import com.gft.inditext.pricing_server.domain.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(assignableTypes = {PricingController.class})
public class ControllerAdvice {

    @ExceptionHandler({EmptyValue.class,
            InvalidDateFormat.class,
            NegativeValue.class,
            NullValue.class}
    )
    public ResponseEntity<FailureResponse> handleException(final RuntimeException exception) {
        log.error(exception.getMessage(), exception);
        final FailureResponse failureResponse = FailureResponse.invalidData(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(failureResponse);
    }

    @ExceptionHandler({ProductPriceNotFound.class})
    public ResponseEntity<FailureResponse> handleProductPriceNotFoundException(final RuntimeException exception) {
        log.error(exception.getMessage(), exception);
        final FailureResponse failureResponse = FailureResponse.notFound(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(failureResponse);
    }

}
