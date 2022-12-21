package com.kgh.web.global.domain.repository;

import com.kgh.web.global.domain.entity.Member;

import java.util.Optional;

public interface IMemberRepository {
    Member save(Member member);
    boolean existsByLoginId(String loginId);

    Optional<Member> findByLoginId(String loginId);
}
