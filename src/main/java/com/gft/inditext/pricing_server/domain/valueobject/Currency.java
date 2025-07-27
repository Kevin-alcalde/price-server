package com.gft.inditext.pricing_server.domain.valueobject;

import com.gft.inditext.pricing_server.domain.util.ObjectUtil;
import com.gft.inditext.pricing_server.domain.util.StringUtil;

public record Currency(String value) implements ValueObject<String> {

    private static final String CLASS_NAME = Currency.class.getName();

    public Currency {
        validate(value);
    }

    private void validate(String value) {
        StringUtil.checkIsNotEmpty(value, CLASS_NAME);
        ObjectUtil.checkNonNull(value, CLASS_NAME);

    }

}
