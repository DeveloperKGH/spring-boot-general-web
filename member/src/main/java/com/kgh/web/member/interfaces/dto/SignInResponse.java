package com.kgh.web.member.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignInResponse {

	@JsonProperty("accessToken")
	private String accessToken;

}
