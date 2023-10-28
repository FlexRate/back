package com.sbb.flexrate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardCreateRequestDto {
    private String dashboard;
    private Long payment; //납입 금액
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payment_date;//납입일
    private Float quarterly_interest_rate;//분기 적용 금리
    private Date loan_maturity_date;//대출 만기일
    private Long remain_loan;//잔여 대출금
    private Long paidback_loan;//상환한 대출금
}
