package com.kgh.web.global.error.exception;

import lombok.Getter;

import java.util.Collections;

public class NotFoundException extends BaseException {

    @Getter
    public enum CauseCode {
        NOT_FOUND_MEMBER("4040000001", "존재하지 않는 회원입니다.");

        private String code;

        private String message;

        CauseCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

    }

    public NotFoundException(CauseCode cause) {
        super(cause.getCode(), cause.getMessage(), Collections.EMPTY_LIST);
    }

}