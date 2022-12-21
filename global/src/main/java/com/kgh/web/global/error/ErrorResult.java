package com.kgh.web.global.error;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class ErrorResult {

	private String field;

	private String message;

}