package com.shopshop.repository;

import com.shopshop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 회원 가입 시 중복된 회원이 있는지 검사하기 위해 쿼리 메소드 작성
    Member findByEmail(String email);
}
