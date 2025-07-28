package com.gft.inditext.pricing_server.domain.valueobject.date;


public final class StartDate extends AbstractDateValueObject {

    public static final String CLASS_NAME = StartDate.class.getSimpleName();

    public StartDate(final String value) {
        super(value, CLASS_NAME);
    }

}