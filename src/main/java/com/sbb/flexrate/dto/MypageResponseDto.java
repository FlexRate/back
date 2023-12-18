package com.sbb.flexrate.dto;

import com.sbb.flexrate.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MypageResponseDto {//마이페이지 response

    private String name;

    private String phonenumber;

    private String email;

    public static MypageResponseDto from(Member member){
        return MypageResponseDto.builder()
                .name(member.getName())
                .phonenumber(member.getPhonenumber())
                .email(member.getEmail())
                .build();
    }
}