package com.kgh.web.global.domain.entity;

import com.kgh.web.global.util.EncryptionUtil;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@EqualsAndHashCode(of = "loginId")
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Table(name = "member")
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Embedded
    private MemberAuthorities authorities = new MemberAuthorities();

    @Builder
    public Member(String loginId, String password) {
        this.loginId = loginId;
        this.password = EncryptionUtil.encodeBcrypt(password);
    }

}
