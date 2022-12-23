package com.kgh.web.global.error.exception;

import com.kgh.web.global.error.ErrorResult;

import java.util.Arrays;
import java.util.List;

public class BadRequestException extends BaseException {

	public BadRequestException(List<ErrorResult> errorResults) {
		super("4000000", "Bad Request", errorResults);
	}

	public BadRequestException(String field, String message) {
		this(Arrays.asList(new ErrorResult(field, message)));
	}

}