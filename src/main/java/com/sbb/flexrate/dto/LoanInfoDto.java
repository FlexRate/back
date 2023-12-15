package com.sbb.flexrate.dto;

import com.sbb.flexrate.domain.Loan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.lang.reflect.Member;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanInfoDto {

    private String name;

    private String insert_time;

    private Long loan_limit;

    private Double loan_initial;

    private Double loan_range_min;

    private Double loan_range_max;


    public static LoanInfoDto from(Loan loan){
        return LoanInfoDto.builder()
                .name(loan.getName())
                .insert_time(loan.getInsert_time())
                .loan_limit(loan.getLoan_limit())
                .loan_initial(loan.getLoan_initial())
                .loan_range_min(loan.getLoan_range_min())
                .loan_range_max(loan.getLoan_range_max())
                .build();
    }
}
