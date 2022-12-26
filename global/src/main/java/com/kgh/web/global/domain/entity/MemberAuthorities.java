package com.kgh.web.global.domain.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(exclude = {"member"})
@ToString(exclude = {"member"})
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Embeddable
public class MemberAuthorities {
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberAuthority> authorities = new ArrayList<>();

    public void add(MemberAuthority authority) {
        this.authorities.add(authority);
    }
}