package com.sbb.flexrate.exception;

import com.sbb.flexrate.member.SignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.print.attribute.standard.MediaSize;


@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(DuplicatedMemberNameException.class)
    public ResponseEntity<CommonErrorResponse> handleDuplicatedMemberNameException(DuplicatedMemberNameException e) {
        CommonErrorResponse response = new CommonErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
    }

    @ExceptionHandler(MissingRequestParameterException.class)
        public ResponseEntity<CommonErrorResponse> handleMissingRequestParameterException(MissingRequestParameterException e) {
            CommonErrorResponse response = new CommonErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
    }

}
