package com.sbb.flexrate.member;

/*
응답, 반환 이용 DTO
 */

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class SignRequest {

    private Long id;

    private String account;

    private String password;

    private String name;

    private String email;

    private String birth;

    private Boolean gender;

    private Boolean nationality;

    private String phonenumber;


}