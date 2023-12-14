package com.sbb.flexrate.member;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {

    private Long id;

    private String account;

    private String name;

    private String email;

    private String birth;

    private Boolean gender;

    private String phonenumber;

    private Boolean nationality;

    private List<Authority> roles=new ArrayList<>();

    private String token;

    public SignResponse(Member member){
        this.id=member.getId();
        this.account=member.getAccount();
        this.name=member.getName();
        this.email=member.getEmail();
        this.birth=member.getBirth();
        this.gender=member.getGender();
        this.nationality=member.getNationality();
        this.phonenumber=member.getPhonenumber();
        this.roles=member.getRoles();
    }
}