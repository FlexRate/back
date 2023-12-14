package com.sbb.flexrate.dto;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.enums.*;
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
public class CreditInfoDto {//마이페이지 credit 정보

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

    public static CreditInfoDto from(Credit credit) {//객체 생성해서 return
        return CreditInfoDto.builder()
                .business_type(credit.getBusiness_type())
                .employment_type(credit.getEmployment_type())
                .company_enter_month(credit.getCompany_enter_month())
                .academic_ability_school(credit.getAcademic_ability_school())
                .yearly_income(credit.getYearly_income())
                .credit_score(credit.getCredit_score())
                .houseown_type(credit.getHouseown_type())
                .personal_rehabilitation_yn(credit.getPersonal_rehabilitation_yn())
                .personal_rehabilitation_complete_yn(credit.getPersonal_rehabilitation_complete_yn())
                .loan_purpose(credit.getLoan_purpose())
                .build();
    }
}