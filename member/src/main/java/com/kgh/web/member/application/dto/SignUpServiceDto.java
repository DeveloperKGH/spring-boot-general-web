package com.kgh.web.member.application.dto;


import com.kgh.web.global.domain.entity.Member;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignUpServiceDto {
    private String loginId;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .loginId(loginId)
                .password(password)
                .build();
    }
}
