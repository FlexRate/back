package com.sbb.flexrate.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.sbb.flexrate.enums.*;
import com.sbb.flexrate.member.Authority;
import com.sbb.flexrate.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.sbb.flexrate.domain.Credit;

import javax.persistence.Column;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/*
credit생성( DTO
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCreateRequestDto {

    private Member member;

    private BusinessType business_type; //업종

    private EmploymentType employment_type; //고용형태

    private String company_enter_month; //입사년월

    private String academic_ability_school; //학력(학교명)

    private AcademicAbility academic_ability; //학력선택

    private Long yearly_income; //연소득

    private Long credit_score; //신용등급

    private HouseownType houseown_type; //주거 정보

    private Boolean personal_rehabilitation_yn; //개인회생자 여부

    private Boolean personal_rehabilitation_complete_yn; //개인회생자 납부 여부

    private LoanPurpose loan_purpose; //대출 목적
}

    //TODO: 범주형변수_ 수입유형, 고용유형, 자가소유유형
/*
    public static CreditCreateRequestDto from(Credit credit){
        return CreditCreateRequestDto.builder()
                .existing_credit_score(credit.getExisting_credit_score())
                .yearly_income(credit.getYearly_income())
                .company_month(credit.getCompany_month())
                .loan_amount(credit.getLoan_amount())
                .debt_rate(credit.getDebt_rate())
                .build();
    }
   //many 형성됨
   */
