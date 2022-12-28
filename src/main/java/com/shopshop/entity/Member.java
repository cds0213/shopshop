package com.shopshop.entity;

import com.shopshop.constant.Role;
import com.shopshop.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;


@Entity
@Table(name="member")
@Getter @Setter
@ToString
public class Member {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    // 회원은 이메일을 통해 구분해야 하기 때문에 동일한 값이 DB에 들어올 수 없도록 unique 속성을 지정.
    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    // enum을 사용할 때 기본적으로 순서가 저장되는데 enum의 순서가 바뀔 경우 문제가 발생할 수 있으므로
    // "EnumType.STRING" 옵션을 사용해서 String으로 저장
    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());


    }



}
