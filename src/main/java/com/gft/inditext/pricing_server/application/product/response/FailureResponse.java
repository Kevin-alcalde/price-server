package com.gft.inditext.pricing_server.application.product.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FailureResponse(String statusCode,
                              String message) {


    public static FailureResponse invalidData(final String message) {
        final String badRequest = String.valueOf(HttpStatus.BAD_REQUEST.value());
        return FailureResponse.builder()
                .statusCode(badRequest)
                .message(message)
                .build();
    }

    public static FailureResponse notFound(final String message) {
        final String notFound = String.valueOf(HttpStatus.NOT_FOUND.value());
        return FailureResponse.builder()
                .statusCode(notFound)
                .message(message)
                .build();
    }

}
