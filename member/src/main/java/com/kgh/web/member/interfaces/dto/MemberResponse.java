package com.kgh.web.member.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberResponse {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("loginId")
	private String loginId;

}
