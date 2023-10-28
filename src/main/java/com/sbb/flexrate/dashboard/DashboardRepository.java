package com.sbb.flexrate.dashboard;

import com.sbb.flexrate.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface DashboardRepository extends JpaRepository<Dashboard,Long> {
    List<Dashboard> findByMember(Member member);
}
