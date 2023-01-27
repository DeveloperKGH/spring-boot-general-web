package com.kgh.web.global.domain.entity;

import com.kgh.web.global.domain.enums.MemberRole;
import com.kgh.web.global.domain.enums.converter.MemberRoleConverter;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@EqualsAndHashCode(exclude = {"member"})
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@ToString(exclude = {"member"})
@Getter
@Table(name = "member_authority")
@Entity
public class MemberAuthority extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "member_id")
    private Member member;


    @Convert(converter = MemberRoleConverter.class)
    @Column(name = "role")
    private MemberRole role;

    @Builder
    public MemberAuthority(Member member, MemberRole role) {
        this.setMember(member);
        this.role = role;
    }

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getAuthorities().getAuthorities().remove(this);
        }

        this.member = member;
        this.member.getAuthorities().getAuthorities().add(this);
    }
}