package com.gft.inditext.pricing_server.domain.valueobject;

import com.gft.inditext.pricing_server.domain.util.NumberUtil;

import java.math.BigDecimal;

public class Price implements ValueObject<BigDecimal> {

    private static final String CLASS_NAME = Price.class.getSimpleName();

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
        NumberUtil.checkIsNotEmtpy(value, CLASS_NAME);
        NumberUtil.checkIsNotNegative(value, CLASS_NAME);
    }

    private BigDecimal convertToBigDecimal(final Number value) {
        return new BigDecimal(value.toString());
    }

}
