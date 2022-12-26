package com.kgh.web.member.application.service;

import com.kgh.web.global.domain.entity.Member;
import com.kgh.web.global.domain.entity.MemberAuthority;
import com.kgh.web.global.domain.enums.MemberRole;
import com.kgh.web.global.domain.repository.IMemberRepository;
import com.kgh.web.global.error.exception.ConflictException;
import com.kgh.web.member.application.dto.SignUpServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        member.getAuthorities().add(MemberAuthority
                .builder()
                .member(member).role(MemberRole.MEMBER).build());

        memberRepository.save(member);

        return member.getId();
    }

}
