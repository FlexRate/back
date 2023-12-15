package com.sbb.flexrate.dto;

import com.sbb.flexrate.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplyRequestDto {

    private Member member;

    private Long name; //성명

    private Date insert_time; //대출 심사 일자

    private Long loan_limit; //대출 가능 한도

    private Long loan_initial; //초기 대출 금리

    private Long loan_range; //금리 범위

}
