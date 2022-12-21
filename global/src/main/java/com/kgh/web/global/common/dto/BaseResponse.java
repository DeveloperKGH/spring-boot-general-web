package com.kgh.web.global.common.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import lombok.Data;

import java.time.ZonedDateTime;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Data
public class BaseResponse<T> {
	private String code;
	private String message;
	private ZonedDateTime timestamp;
	private T data;

	public static <T> BaseResponse<T> successResponse(T data) {
		BaseResponse<T> response = new BaseResponse<>();
		response.setCode("200");
		response.setMessage("SUCCESS");
		response.setTimestamp(ZonedDateTime.now());
		response.setData(data);
		return response;
	}

	public static <T> BaseResponse<T> errorResponse(String code, String message, T data) {
		BaseResponse<T> response = new BaseResponse<>();
		response.setCode(code);
		response.setMessage(message);
		response.setTimestamp(ZonedDateTime.now());
		response.setData(data);
		return response;
	}
}