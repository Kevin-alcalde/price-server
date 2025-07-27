package com.gft.inditext.pricing_server.domain.valueobject;

public record PriceList(Integer value) implements ValueObject<Integer> {

    public PriceList {
        validate(value);
    }

    private void validate(final Integer value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Price list value must be a non-negative integer.");
        }
    }

}
