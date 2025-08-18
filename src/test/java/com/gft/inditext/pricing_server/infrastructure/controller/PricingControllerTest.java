package com.gft.inditext.pricing_server.infrastructure.controller;

import com.gft.inditext.pricing_server.application.product.request.PriceRequest;
import com.gft.inditext.pricing_server.application.product.response.PriceResponse;
import com.gft.inditext.pricing_server.application.usecase.GetProductPriceUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class PricingControllerTest {

    @InjectMocks
    PricingController pricingController;

    @Mock
    GetProductPriceUseCase getProductPriceUseCase;

    @Test
    void givenProductPriceRequest_whenGetProductPrice_thenCallsGetProductPriceUseCaseAndReturnsProductPriceResponse() {
        // Given
        final int productId = 1;
        final long brandId = 35455L;
        final String date = "2023-10-01";
        final int priceId = 4;
        final PriceRequest priceRequest = new PriceRequest(date, productId, brandId);
        final Number number = 35.50;
        final PriceResponse expectedPriceResponse = new PriceResponse(productId, brandId, priceId, date, date, number);
        Mockito.when(getProductPriceUseCase.execute(Mockito.any())).thenReturn(expectedPriceResponse);

        // When
        final ResponseEntity<PriceResponse> response = pricingController.getPrice(priceRequest);

        // Then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(expectedPriceResponse, response.getBody());
        Mockito.verify(getProductPriceUseCase, Mockito.times(1)).execute(Mockito.any());
    }


}