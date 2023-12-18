package com.sbb.flexrate.dto;

import com.sbb.flexrate.domain.Apply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplyResponseDto {

    private Long loan_request; //대출 금액

    private Long loan_repay_term; //대출 상환 기간

    public static ApplyResponseDto from(Apply apply){
        return ApplyResponseDto.builder()
                .loan_request(apply.getLoan_request())
                .loan_repay_term(apply.getLoan_repay_term())
                .build();
    }



}
