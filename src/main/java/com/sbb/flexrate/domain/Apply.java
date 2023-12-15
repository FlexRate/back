package com.sbb.flexrate.domain;

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
    private Long name; //성명

    @Column
    private Date insert_time; //대출 심사 일자

    @Column
    private Long loan_limit; //대출 가능 한도

    @Column
    private Long loan_initial; //초기 대출 금리

    @Column
    private Long loan_range; //금리 범위

}
