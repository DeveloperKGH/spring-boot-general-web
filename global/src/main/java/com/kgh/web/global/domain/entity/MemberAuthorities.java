package com.kgh.web.global.domain.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@EqualsAndHashCode(exclude = {"authorities"})
@ToString(exclude = {"authorities"})
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Embeddable
public class MemberAuthorities {
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = EAGER)
    private List<MemberAuthority> authorities = new ArrayList<>();

    public void add(MemberAuthority authority) {
        this.authorities.add(authority);
    }
}