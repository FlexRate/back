package com.sbb.flexrate.service;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.domain.Loan;
import com.sbb.flexrate.dto.CreditCreateRequestDto;
import com.sbb.flexrate.dto.LoanCreateRequestDto;
import com.sbb.flexrate.dto.LoanInfoDto;
import com.sbb.flexrate.exception.DataNotFoundException;
import com.sbb.flexrate.member.Member;
import com.sbb.flexrate.member.MemberRepository;
import com.sbb.flexrate.repository.CreditRepository;
import com.sbb.flexrate.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoanService {
    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;

    public void updateLoan(Long memberId, LoanCreateRequestDto loanDto) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            Optional<Loan> optionalLoan = loanRepository.findByMemberId(memberId);
            if (optionalLoan.isPresent()) {
                Loan loan = optionalLoan.get();

                // Check if loanDto and its member are not null before accessing properties
                if (loanDto != null && loanDto.getMember() != null) {
                    loan.setName(loanDto.getMember().getName());
                }


                loan.setInsert_time(loanDto.getInsert_time());
                loan.setLoan_limit(loanDto.getLoan_limit());
                loan.setLoan_initial(loanDto.getLoan_initial());
                loan.setLoan_range_min(loanDto.getLoan_range_min());
                loan.setLoan_range_max(loanDto.getLoan_range_max());

                loanRepository.save(loan);
            } else {
                System.out.println(memberId);
                throw new DataNotFoundException("해당 Member의 Loan 조회 실패");
            }
        } else {
            throw new DataNotFoundException("Member 조회 실패");
        }
    }


    public LoanInfoDto getLoanInfo(Long memberId){
        Optional<Member> member=memberRepository.findById(memberId);
        if(member.isPresent()){
            Loan loan=member.get().getLoan();
            return LoanInfoDto.from(loan);
        }else throw new DataNotFoundException("Member 조회 실패");
    }
}