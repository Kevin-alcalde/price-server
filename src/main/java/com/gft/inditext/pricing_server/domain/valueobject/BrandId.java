package com.gft.inditext.pricing_server.domain.valueobject;

import com.gft.inditext.pricing_server.domain.util.LongUtil;

public record BrandId(Long value) implements ValueObject<Long> {

    private static final String CLASS_NAME = BrandId.class.getSimpleName();

    public BrandId {
        validate(value);
    }

    private void validate(final Long value) {
        LongUtil.checkIsNotEmpty(value, CLASS_NAME);
        LongUtil.checkIsNotNull(value, CLASS_NAME);
    }

}
