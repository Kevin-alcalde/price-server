package com.gft.inditext.pricing_server.domain.valueobject;

public record ProductId(Integer value) implements ValueObject<Integer> {

    public ProductId {
        validate(value);
    }

    private void validate(Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Product ID must be a positive integer.");
        }
    }

}
