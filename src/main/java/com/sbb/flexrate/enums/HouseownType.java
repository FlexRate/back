package com.sbb.flexrate.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum HouseownType {
    OWNHOUSE("1"),
    RENT("2"),
    OTHER("3");

    private final String value;

    private HouseownType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static HouseownType fromValue(String value) {
        return Arrays.stream(HouseownType.values())
                .filter(houseownType -> houseownType.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}


