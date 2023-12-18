package com.sbb.flexrate.repository;

import com.sbb.flexrate.domain.Apply;
import com.sbb.flexrate.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplyRepository extends JpaRepository<Apply,Long> {
//    Optional<Apply> findByMemberId(Long memberId);
    Optional<Apply> findByMember(Member member);
}