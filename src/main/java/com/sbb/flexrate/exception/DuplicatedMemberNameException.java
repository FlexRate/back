
package com.sbb.flexrate.exception;

import javax.servlet.http.HttpServletResponse;


public class DuplicatedMemberNameException extends RuntimeException {
    public DuplicatedMemberNameException() {
        super("이미 존재하는 account입니다.");
    }
}

