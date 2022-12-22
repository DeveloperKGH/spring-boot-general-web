package com.kgh.web.global.error.exception;

import lombok.Getter;

import java.util.Collections;

public class ConflictException extends BaseException {

    @Getter
    public enum CauseCode {
        DUPLICATE_LOGIN_ID("4090000001", "아이디가 중복됩니다.");

        private String code;
        private String message;

        CauseCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

    }

    public ConflictException(CauseCode cause) {
        super(cause.getCode(), cause.getMessage(), Collections.EMPTY_LIST);
    }

}