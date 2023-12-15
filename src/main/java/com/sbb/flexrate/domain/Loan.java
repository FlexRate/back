    package com.sbb.flexrate.domain;

    import com.sbb.flexrate.domain.Credit;
    import com.sbb.flexrate.dto.LoanCreateRequestDto;
    import com.sbb.flexrate.member.Member;
    import lombok.*;

    import javax.persistence.*;
    import java.util.Date;

    @Getter
    @Setter
    @Entity
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="loan")
    public class Loan {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="loan_id")
        private Long id;

        @OneToOne
        @JoinColumn(name = "member_id")
        private Member member;

        @Column
        private String name; //성명

        @Column
        private String insert_time; //대출 심사 일자

        @Column
        private Long loan_limit; //대출 가능 한도

        @Column
        private Double loan_initial; //초기 대출 금리

        @Column
        private Double loan_range_min; //금리 범위 최소값

        @Column
        private Double loan_range_max; //금리 범위 최대값

        public static Loan from(LoanCreateRequestDto loanDto){
            return Loan.builder()
                    .name(loanDto.getName())
                    .insert_time(loanDto.getInsert_time())
                    .loan_limit(loanDto.getLoan_limit())
                    .loan_initial(loanDto.getLoan_initial())
                    .loan_range_min(loanDto.getLoan_range_min())
                    .loan_range_max(loanDto.getLoan_range_max())
                    .build();
        }
    }

    /*
    금리 엔티티
     */