package com.sbb.flexrate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanApplicationDTO {
    private float birth_year;
    private float gender;
    private float credit_score;
    private float yearly_income;
    private float company_enter_month;
    private float existing_loan_cnt;
    private float existing_loan_amt;
    private int personal_rehabilitation_ing;
    private int personal_rehabliltation_done;
    private float 한국은행_기준금리;
    private float pc1;
    private boolean income_type_EARNEDINCOME2;
    private boolean income_type_FREELANCER;
    private boolean income_type_OTHERINCOME;
    private boolean income_type_PRACTITIONER;
    private boolean income_type_PRIVATEBUSINESS;
    private boolean employment_type_기타;
    private boolean employment_type_일용직;
    private boolean employment_type_정규직;
    private boolean houseown_type_배우자;
    private boolean houseown_type_자가;
    private boolean houseown_type_전월세;
    private boolean purpose_BUYCAR;
    private boolean purpose_HOUSEDEPOSIT;
    private boolean purpose_기타;
    private boolean purpose_대환대출;
    private boolean purpose_사업자금;
    private boolean purpose_생활비;
    private boolean purpose_자동차구입;
    private boolean purpose_전월세보증금;
    private boolean purpose_주택구입;
    private boolean purpose_투자;
}
