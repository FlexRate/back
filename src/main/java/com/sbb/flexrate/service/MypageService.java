package com.sbb.flexrate.service;

import com.sbb.flexrate.dto.MypageResponseDto;
import com.sbb.flexrate.member.Member;
import com.sbb.flexrate.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MypageService {
    private final MemberRepository memberRepository;

    public MypageResponseDto getMypageInfo(Long memberId) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            return MypageResponseDto.from(member);
        } else {
            // Optional에서 멤버를 찾을 수 없는 경우에 대한 예외 처리 또는 기본값 설정
            throw new RuntimeException("해당 ID의 멤버를 찾을 수 없습니다: " + memberId);
        }
    }
}
