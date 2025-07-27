package com.gft.inditext.pricing_server.infrastructure.controller;

import com.gft.inditext.pricing_server.application.product.request.PriceRequest;
import com.gft.inditext.pricing_server.application.product.response.PriceResponse;
import com.gft.inditext.pricing_server.application.usecase.GetProductPriceUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "product/pricing")
@Tag(name = "Product Pricing API", description = "API to get the applicable price for a product in a given timestamp")
public class PricingController {

    private final GetProductPriceUseCase getProductPriceUseCase;

    @PostMapping(path = "/price")
    public ResponseEntity<PriceResponse> getPrice(@RequestBody final PriceRequest priceRequest) {
        log.info("getPrice method called with input data: {}", priceRequest);
        final PriceResponse productPriceResponse = getProductPriceUseCase.execute(priceRequest);
        return ResponseEntity
                .ok()
                .body(productPriceResponse);
    }

}
