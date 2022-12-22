package com.kgh.web.member.interfaces.dto;

import com.kgh.web.member.application.dto.SignUpServiceDto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor @NoArgsConstructor
@Builder
@Setter @Getter
@ToString
@EqualsAndHashCode
public class SignUpRequest {

    @NotBlank()
    private String loginId;

    @NotBlank()
    private String password;

    public SignUpServiceDto toServiceDto() {
        return SignUpServiceDto.builder()
                .loginId(loginId)
                .password(password)
                .build();
    }

}
