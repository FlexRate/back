package com.sbb.flexrate.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum BusinessType {
    OFFICE_WORKER("직장인"),
    ENTREPRENEUR("사업자"),
    FREELANCER("프리랜서"),
    OTHER("기타");

    private final String name;

    private BusinessType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return this.name;
    }

    @JsonCreator
    public static BusinessType fromName(String name) {
        return Arrays.stream(BusinessType.values())
                .filter(value -> value.name.equals(name))
                .findFirst()
                .orElse(null);
    }
}
