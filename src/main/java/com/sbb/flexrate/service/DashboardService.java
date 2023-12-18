package com.sbb.flexrate.service;

import com.sbb.flexrate.domain.Apply;
import com.sbb.flexrate.domain.Change;
import com.sbb.flexrate.domain.Loan;
import com.sbb.flexrate.dto.DashboardResponseDto;
import com.sbb.flexrate.exception.DataNotFoundException;
import com.sbb.flexrate.member.Member;
import com.sbb.flexrate.member.MemberRepository;
import com.sbb.flexrate.repository.ApplyRepository;
import com.sbb.flexrate.repository.ChangeRepository;
import com.sbb.flexrate.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class DashboardService {

    private final LoanRepository loanRepository;
    private final ApplyRepository applyRepository;
    private final ChangeRepository changeRepository;
    private final MemberRepository memberRepository;

    public DashboardResponseDto getInfo(Long memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new DataNotFoundException("Member 조회 실패: ID " + memberId));

        Loan loan = loanRepository.findByMember(member)
                .orElseThrow(() -> new DataNotFoundException("Loan 조회 실패: Member ID " + memberId));

        Apply apply = applyRepository.findByMember(member)
                .orElseThrow(() -> new DataNotFoundException("Apply 조회 실패: Member ID " + memberId));

        List<Change> changes = changeRepository.findByMember(member);

        return DashboardResponseDto.builder()
                .loan_request(apply.getLoan_request())
                .loan_repay_term(apply.getLoan_repay_term())
                .loan_payment_count(0L) // 0으로 반환
                .loan_initial(loan.getLoan_initial())
                .insert_time(loan.getInsert_time())
                .loan_range_min(loan.getLoan_range_min())
                .loan_range_max(loan.getLoan_range_max())
                .changes(changes)
                .build();
    }
}
