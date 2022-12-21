package com.kgh.web.global.infra;


import com.kgh.web.global.domain.entity.Member;
import com.kgh.web.global.domain.repository.IMemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends IMemberRepository, JpaRepository<Member, Long> {
    boolean existsByLoginId(String loginId);

}
