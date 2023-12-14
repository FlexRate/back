package com.sbb.flexrate.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum AcademicAbility {
    HIGHSCHOOL("고졸"),
    JUNIORCOLLEGE("전문대졸"),
    COLLEGE("대졸"),
    MASTER("석사"),
    DOCTOR("박사");

    private final String name;

    private AcademicAbility(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return this.name;
    }

    @JsonCreator
    public static AcademicAbility fromName(String name) {
        return Arrays.stream(AcademicAbility.values())
                .filter(value -> value.name.equals(name))
                .findFirst()
                .orElse(null);
    }
}
