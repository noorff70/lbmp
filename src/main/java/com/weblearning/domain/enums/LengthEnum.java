package com.weblearning.domain.enums;

public enum LengthEnum {
	
    MILI(1),
    CENTI(10),
    DECI(100),
    METER(1000);

    private int unit;

    LengthEnum(int u) {
        this.unit = u;
    }

    public int getUnit() {
        return unit;
    }
}
