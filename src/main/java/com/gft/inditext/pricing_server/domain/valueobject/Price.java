package com.gft.inditext.pricing_server.domain.valueobject;

import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;

public class Price implements ValueObject<BigDecimal> {

    private final BigDecimal value;

    public Price(final Number value) {
        validate(value);
        this.value = convertToBigDecimal(value);
    }

    @Override
    public BigDecimal value() {
        return value;
    }

    private void validate(final Number value) {
        if (ObjectUtils.isEmpty(value)) {
            throw new NullPointerException("Price value cannot be null");
        }
        if (value.doubleValue() < 0) {
            throw new IllegalArgumentException("Price value cannot be negative");
        }
    }

    private BigDecimal convertToBigDecimal(final Number value) {
        return new BigDecimal(value.toString());
    }

}
