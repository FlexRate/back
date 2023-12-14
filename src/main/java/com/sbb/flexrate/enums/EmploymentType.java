package com.sbb.flexrate.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum EmploymentType {
    REGULAR("정규직"),
    DAILYWORKER("일용직"),
    OTHER("기타");

    private final String name;

    private EmploymentType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return this.name;
    }

    @JsonCreator
    public static EmploymentType fromName(String name) {
        return Arrays.stream(EmploymentType.values())
                .filter(value -> value.name.equals(name))
                .findFirst()
                .orElse(null);
    }
}

