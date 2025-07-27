package com.gft.inditext.pricing_server.domain.valueobject;

public record BrandId(Long value) implements ValueObject<Long> {

    public BrandId {
        validate(value);
    }

    private void validate(Long value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Brand ID must be a positive integer.");
        }
    }

}
