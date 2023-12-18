package com.sbb.flexrate.dto;

import com.sbb.flexrate.domain.Change;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardResponseDto {

    private Long loan_request; //대출 금액

    private Long loan_repay_term; //대출 상환 기간

    private Long loan_payment_count; //0으로 반환

    private Double loan_initial; //초기 대출 금리

    private String insert_time; //대출 심사 일자

    private Double loan_range_min; //금리 범위 최소값

    private Double loan_range_max; //금리 범위 최대값

    private List<Change> changes; //변동 리스트

    private Long creditScore;

    private Long newCreditScore;
}
