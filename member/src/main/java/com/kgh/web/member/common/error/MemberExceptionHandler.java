package com.kgh.web.member.common.error;

import com.kgh.web.global.common.dto.BaseResponse;
import com.kgh.web.global.error.ErrorResult;
import com.kgh.web.global.error.exception.BadRequestException;
import com.kgh.web.global.error.exception.BaseException;
import com.kgh.web.global.error.exception.ConflictException;
import com.kgh.web.global.error.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class MemberExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public BaseResponse<List<ErrorResult>> handle400Exception(HttpServletRequest request, BadRequestException exception) {
		printError(request, exception);
		return BaseResponse.errorResponse(exception.getCode(), exception.getMessage(), exception.getErrorResults());
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public BaseResponse<List<ErrorResult>> handle404Exception(HttpServletRequest request, NotFoundException exception) {
		printError(request, exception);
		return BaseResponse.errorResponse(exception.getCode(), exception.getMessage(), exception.getErrorResults());
	}

	@ExceptionHandler(ConflictException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public BaseResponse<List<ErrorResult>> handle409Exception(HttpServletRequest request, ConflictException exception) {
		printError(request, exception);
		return BaseResponse.errorResponse(exception.getCode(), exception.getMessage(), exception.getErrorResults());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public BaseResponse<List> handle500Exception(Exception exception) {
		log.error("===============Print 500 Error===============");
		log.error("[ExceptionHandle] trace : {}", exception);
		log.error("=========================================");
		return BaseResponse.errorResponse("5000000000", exception.getMessage(), Collections.EMPTY_LIST);
	}

	private void printError(HttpServletRequest request, BaseException exception) {
		log.error("===============PrintError===============");
		log.error("[ExceptionHandle] request-url: {}", request.getRequestURL());
		log.error("[ExceptionHandle] error: {}", exception.getCode());
		log.error("[ExceptionHandle] message: {}", exception.getMessage());
		log.error("[ExceptionHandle] errorResults: {}", exception.getErrorResults());
		log.error("=========================================");

	}

}