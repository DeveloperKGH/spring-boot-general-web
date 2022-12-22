package com.kgh.web.member.interfaces.dto;

import com.kgh.web.member.application.dto.SignInServiceDto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor @NoArgsConstructor
@Builder
@Setter @Getter
@ToString
@EqualsAndHashCode
public class SignInRequest {

    @NotBlank()
    private String loginId;

    @NotBlank()
    private String password;

    public SignInServiceDto toServiceDto() {
        return SignInServiceDto.builder()
                .loginId(loginId)
                .password(password)
                .build();
    }

}
