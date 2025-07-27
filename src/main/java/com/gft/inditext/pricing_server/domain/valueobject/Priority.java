package com.gft.inditext.pricing_server.domain.valueobject;

import com.gft.inditext.pricing_server.domain.util.IntegerUtil;

public record Priority(Integer value) implements ValueObject<Integer> {

    private static final String CLASS_NAME = Priority.class.getSimpleName();

    public Priority {
        validate(value);
    }

    private void validate(final Integer value) {
        IntegerUtil.checkIsNotEmpty(value, CLASS_NAME);
        IntegerUtil.checkIsNotNull(value, CLASS_NAME);
        IntegerUtil.checkIsNotNegative(value, CLASS_NAME);
    }

}
