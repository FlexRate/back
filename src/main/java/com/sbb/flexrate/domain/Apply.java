package com.sbb.flexrate.domain;

import com.sbb.flexrate.dto.ApplyRequestDto;
import com.sbb.flexrate.member.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="apply")
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="apply_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column
    private Long loan_request; //대출 금액

    @Column
    private Long loan_repay_term; //대출 상환 기간

    public static Apply from(ApplyRequestDto applyRequestDto){
        return Apply.builder()
                .loan_request(applyRequestDto.getLoan_request())
                .loan_repay_term(applyRequestDto.getLoan_repay_term())
                .build();
    }


}
