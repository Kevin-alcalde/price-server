package com.gft.inditext.pricing_server.infrastructure;

import com.gft.inditext.pricing_server.infrastructure.controller.PricingController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(assignableTypes = {PricingController.class})
public class ControllerAdvice {
}
