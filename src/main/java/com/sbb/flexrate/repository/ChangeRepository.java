package com.sbb.flexrate.repository;

import com.sbb.flexrate.domain.Change;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChangeRepository extends JpaRepository<Change, Long> {
    // 멤버 ID를 기반으로 Change 엔터티를 찾는 메서드 추가
    Optional<Change> findByMemberId(Long memberId);
}
