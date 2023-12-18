package com.sbb.flexrate.controller;

import com.sbb.flexrate.dto.MypageResponseDto;
import com.sbb.flexrate.exception.DataNotFoundException;
import com.sbb.flexrate.member.MemberRepository;
import com.sbb.flexrate.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MypageController {
    private final MypageService mypageService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MypageResponseDto> getMypageInfo(@PathVariable Long memberId, @RequestBody MemberRepository memberRepository){
        try {
            MypageResponseDto mypageResponseDto=mypageService.getMypageInfo(memberId);
            return ResponseEntity.ok(mypageResponseDto);
        }catch (DataNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}
