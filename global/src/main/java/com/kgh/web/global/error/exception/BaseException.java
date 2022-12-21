package com.kgh.web.global.error.exception;

import com.kgh.web.global.error.ErrorResult;
import lombok.*;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {

    public String code;

    public String message;

    public List<ErrorResult> errorResults;

}
