package com.gft.inditext.pricing_server.domain.valueobject;

public record Currency(String value) implements ValueObject<String> {

    public Currency {
        validate(value);
    }

    private void validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Currency value cannot be null");
        }
    }

}
