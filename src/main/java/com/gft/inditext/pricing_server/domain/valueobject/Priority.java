package com.gft.inditext.pricing_server.domain.valueobject;

public record Priority(Integer value) implements ValueObject<Integer> {

    public Priority {
        validate(value);
    }

    private void validate(final Integer value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Priority must be a non-negative integer.");
        }
    }

}
