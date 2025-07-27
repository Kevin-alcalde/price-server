package com.gft.inditext.pricing_server.domain.valueobject;

import com.gft.inditext.pricing_server.domain.util.IntegerUtil;

public record ProductId(Integer value) implements ValueObject<Integer> {

    private static final String CLASS_NAME = ProductId.class.getSimpleName();

    public ProductId {
        validate(value);
    }

    private void validate(final Integer value) {
        IntegerUtil.checkIsNotNull(value, CLASS_NAME);
        IntegerUtil.checkIsNotEmpty(value, CLASS_NAME);
        IntegerUtil.checkIsNotNegative(value, CLASS_NAME);
    }

}
