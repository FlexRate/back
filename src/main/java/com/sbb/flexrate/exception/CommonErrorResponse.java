package com.sbb.flexrate.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class CommonErrorResponse {

    @JsonProperty("status")
    private int status;
    @JsonProperty("message")
    private String message;

    public CommonErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
