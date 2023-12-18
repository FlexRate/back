package com.sbb.flexrate.service;

import com.sbb.flexrate.domain.Apply;
import com.sbb.flexrate.domain.Change;
import com.sbb.flexrate.domain.Loan;
import com.sbb.flexrate.dto.ApplyResponseDto;
import com.sbb.flexrate.dto.LoanCreateRequestDto;
import com.sbb.flexrate.dto.LoanInfoDto;
import com.sbb.flexrate.dto.ApplyRequestDto;
import com.sbb.flexrate.exception.DataNotFoundException;
import com.sbb.flexrate.member.Member;
import com.sbb.flexrate.member.MemberRepository;
import com.sbb.flexrate.repository.ApplyRepository;
import com.sbb.flexrate.repository.ChangeRepository;
import com.sbb.flexrate.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoanService {
    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;
    private final ApplyRepository applyRepository;
    private final ChangeRepository changeRepository;

    public void updateLoan(Long memberId, LoanCreateRequestDto loanDto) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            Optional<Loan> optionalLoan = loanRepository.findByMember(member.get());
            if (optionalLoan.isPresent()) {
                Loan loan = optionalLoan.get();

//                if (loanDto != null && loanDto.getMember() != null) {
//                    loan.setName(loanDto.getMember().getName());
//                }

                loan.setName(member.get().getName());
                loan.setInsert_time(loanDto.getInsert_time());
                loan.setLoan_limit(loanDto.getLoan_limit());
                loan.setLoan_initial(loanDto.getLoan_initial());
                loan.setLoan_range_min(loanDto.getLoan_range_min());
                loan.setLoan_range_max(loanDto.getLoan_range_max());
                loan.setNewCreditScore(loanDto.getNewCreditScore());

                loanRepository.save(loan);

//                Optional<Change> optionalChange=changeRepository.findByMemberId(memberId);

                Change change = Change.builder()
                        .member(member.get())
                        .change_insert_time(loan.getInsert_time())
                        .change_loan_initial(loan.getLoan_initial())
                        .build();
                changeRepository.save(change);

//                change.updateFromLoan(loan, changeRepository);
//
//                public void updateFromLoan(Loan loan,ChangeRepository changeRepository) {
//                    Change newChange=Change.builder()
//                            .member(loan.getMember())
//                            .change_insert_time(loan.getInsert_time())
//                            .change_loan_initial(loan.getLoan_initial())
//                            .build();
//
//                    changeRepository.save(newChange);
//                }

//                if(optionalChange.isPresent()){
//                    change=optionalChange.get();
//                    change.updateFromLoan(loan,changeRepository);
//                }else{
//                    change = Change.builder().member(member.get()).build();
//                    change.updateFromLoan(loan, changeRepository);
//
//                }

            } else {
                System.out.println(memberId);
                throw new DataNotFoundException("해당 Member의 Loan 조회 실패");
            }
        } else {
            throw new DataNotFoundException("Member 조회 실패");
        }
    }

    public void applyLoan(Long memberId, ApplyRequestDto applyDto) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            Optional<Apply> optionalApply = applyRepository.findByMember(member.get());
            if (optionalApply.isPresent()) {
                Apply apply = optionalApply.get();

                apply.setLoan_request(applyDto.getLoan_request());
                apply.setLoan_repay_term(applyDto.getLoan_repay_term());

                applyRepository.save(apply);

            } else {
                System.out.println(memberId);
                throw new DataNotFoundException("해당 Member의 Loan 조회 실패");
            }
        }
        else{
            throw new DataNotFoundException("Member 조회 실패");
        }
    }

    public LoanInfoDto getLoanInfo (Long memberId){
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            Optional<Loan> loan = loanRepository.findByMember(member.get());
            return LoanInfoDto.from(loan.get());
        }else throw new DataNotFoundException("Member 조회 실패");
    }

    public ApplyResponseDto getApplyInfo (Long memberId){
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            Optional<Apply> apply = applyRepository.findByMember(member.get());
            return ApplyResponseDto.from(apply.get());
        } else throw new DataNotFoundException("Member 조회 실패");
    }
    }
