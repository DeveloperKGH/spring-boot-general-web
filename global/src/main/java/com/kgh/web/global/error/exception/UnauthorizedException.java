package com.kgh.web.global.error.exception;

import lombok.Getter;

import java.util.Collections;

public class UnauthorizedException extends BaseException {

    @Getter
    public enum CauseCode {
        INVALID_TOKEN("4010000001", "유효하지 않은 토큰입니다.");

        private String code;
        private String message;

        CauseCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

    }

    public UnauthorizedException(CauseCode cause) {
        super(cause.getCode(), cause.getMessage(), Collections.EMPTY_LIST);
    }

}