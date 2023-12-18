package com.sbb.flexrate.dto;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.domain.Loan;
import com.sbb.flexrate.member.Member;
import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanCreateRequestDto {

    private String name;

    private String insert_time;

    private Long loan_limit;

    private Double loan_initial;

    private Double loan_range_min;

    private Double loan_range_max;
}