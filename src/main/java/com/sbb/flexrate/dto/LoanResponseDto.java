package com.sbb.flexrate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseDto {


        private String name;

        private String insert_time;

        private Long loan_limit;

        private Double loan_initial;

        private Double loan_range_min;

        private Double loan_range_max;

        private Long newCreditScore;

        private LoanResponseDto LoanResponseDto(LoanCreateRequestDto loanDto) {
                LoanResponseDto responseDto = new LoanResponseDto();
                responseDto.setName(loanDto.getName());
                responseDto.setInsert_time(loanDto.getInsert_time());
                responseDto.setLoan_limit(loanDto.getLoan_limit());
                responseDto.setLoan_initial(loanDto.getLoan_initial());
                responseDto.setLoan_range_min(loanDto.getLoan_range_min());
                responseDto.setLoan_range_max(loanDto.getLoan_range_max());
                return responseDto;
        }

}
