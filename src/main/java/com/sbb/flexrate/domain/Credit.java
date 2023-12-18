package com.sbb.flexrate.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sbb.flexrate.dto.CreditCreateRequestDto;
import com.sbb.flexrate.enums.*;
import com.sbb.flexrate.member.Authority;
import com.sbb.flexrate.member.Member;
import com.sbb.flexrate.domain.Loan;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="credit")
public class Credit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name="credit_info")
    private BusinessType business_type; //업종

    @Column
    private EmploymentType employment_type; //고용형태

    @Column
    private String company_enter_month; //입사년월

    @Column
    private String academic_ability_school; //학력(학교명)

    @Column
    private AcademicAbility academic_ability; //학력선택

    @Column
    private Long yearly_income; //연소득

    @Column
    private Long credit_score; //신용등급

    @Column
    private HouseownType houseown_type; //주거 정보

    @Column
    private Boolean personal_rehabilitation_yn; //개인회생자 여부

    @Column
    private Boolean personal_rehabilitation_complete_yn; //개인회생자 납부 여부

    @Column
    private LoanPurpose loan_purpose; //대출 목적

    public static Credit from(CreditCreateRequestDto creditDto){
        return Credit.builder()
                .business_type(creditDto.getBusiness_type())
                .employment_type(creditDto.getEmployment_type())
                .company_enter_month(creditDto.getCompany_enter_month())
                .academic_ability_school(creditDto.getAcademic_ability_school())
                .academic_ability(creditDto.getAcademic_ability())
                .yearly_income(creditDto.getYearly_income())
                .credit_score(creditDto.getCredit_score())
                .houseown_type(creditDto.getHouseown_type())
                .personal_rehabilitation_yn(creditDto.getPersonal_rehabilitation_yn())
                .personal_rehabilitation_complete_yn(creditDto.getPersonal_rehabilitation_complete_yn())
                .loan_purpose(creditDto.getLoan_purpose())
                .build();
        }
}
