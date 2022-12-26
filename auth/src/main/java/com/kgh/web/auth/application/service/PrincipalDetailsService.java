package com.kgh.web.auth.application.service;

import com.kgh.web.auth.domain.PrincipalDetail;
import com.kgh.web.global.domain.entity.Member;
import com.kgh.web.global.domain.repository.IMemberRepository;
import com.kgh.web.global.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {
    private final IMemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws NotFoundException {
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new NotFoundException(NotFoundException.CauseCode.NOT_FOUND_MEMBER));
        return new PrincipalDetail(member);
    }
}
