package com.kgh.web.member.application.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignInServiceDto {
    private String loginId;
    private String password;
}
