package com.sbb.flexrate.dto;

import com.sbb.flexrate.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplyRequestDto {

    private Long loan_request; //대출 금액

    private Long loan_repay_term; //대출 상환 기간

}
