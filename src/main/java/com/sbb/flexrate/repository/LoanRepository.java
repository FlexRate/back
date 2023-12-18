package com.sbb.flexrate.repository;

import com.sbb.flexrate.domain.Loan;
import com.sbb.flexrate.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan,Long> {
    Optional<Loan> findByMember(Member member);//사용자 아이디 기반 credit 정보 조회
}