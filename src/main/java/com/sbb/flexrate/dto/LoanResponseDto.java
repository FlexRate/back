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

}
