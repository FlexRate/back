package com.sbb.flexrate.domain;

import com.sbb.flexrate.dto.LoanCreateRequestDto;
import com.sbb.flexrate.member.Member;
import com.sbb.flexrate.repository.ChangeRepository;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="change_log")
public class Change {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="change_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column
    private String change_insert_time;

    @Column
    private Double change_loan_initial;

    public void updateFromLoan(Loan loan,ChangeRepository changeRepository) {
        Change newChange=Change.builder()
                .member(loan.getMember())
                .change_insert_time(loan.getInsert_time())
                .change_loan_initial(loan.getLoan_initial())
                .build();

        changeRepository.save(newChange);
    }
}