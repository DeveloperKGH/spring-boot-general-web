package com.kgh.web.member.application.service;

import com.kgh.web.auth.common.util.JwtTokenProvider;
import com.kgh.web.global.domain.entity.Member;
import com.kgh.web.global.domain.repository.IMemberRepository;
import com.kgh.web.global.error.exception.ConflictException;
import com.kgh.web.global.error.exception.NotFoundException;
import com.kgh.web.global.util.EncryptionUtil;
import com.kgh.web.member.application.dto.SignInServiceDto;
import com.kgh.web.member.application.dto.SignUpServiceDto;
import com.kgh.web.member.interfaces.dto.SignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final IMemberRepository memberRepository;

    @Transactional
    public Long signup(SignUpServiceDto dto) {
        if (memberRepository.existsByLoginId(dto.getLoginId())) {
            throw new ConflictException(ConflictException.CauseCode.DUPLICATE_LOGIN_ID);
        }

        Member member = dto.toEntity();
        member.encryptPassword();
        memberRepository.save(member);

        return member.getId();
    }

    @Transactional
    public SignInResponse signIn(SignInServiceDto dto) {
        Member member = memberRepository.findByLoginId(dto.getLoginId())
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        if (!EncryptionUtil.matchesBcrypt(dto.getPassword(), member.getPassword())) {
            throw new NotFoundException(NotFoundException.CauseCode.NOT_FOUND_MEMBER);
        }

        String token = JwtTokenProvider.generateAccessToken(dto.getLoginId(), Collections.emptyList());
        return SignInResponse.builder()
                .accessToken(token)
                .build();
    }
}
