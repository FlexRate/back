package com.sbb.flexrate.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum LoanPurpose {
    HOUSE("주택 구매"),
    EDUCATION("교육비"),
    BUSINESS("사업/창업"),
    DEBT("부채 통합"),
    OTHER("기타");

    private final String name;

    private LoanPurpose(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return this.name;
    }

    @JsonCreator
    public static LoanPurpose fromName(String name) {
        return Arrays.stream(LoanPurpose.values())
                .filter(loanPurpose -> loanPurpose.name.equals(name))
                .findFirst()
                .orElse(null);
    }
}

