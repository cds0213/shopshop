package com.shopshop.service;


import com.shopshop.entity.Member;
import com.shopshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 로직을 처리하다가 에러가 발생하면 변경된 데이터를 수행하기 이전의 상태로 콜백 시켜줌.
@RequiredArgsConstructor // final이나 @NonNull이 붙은 필드에 생성자를 생성해줌.
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) { // 이미 가입된 회원인 경우 예외 발생
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
     }
}

