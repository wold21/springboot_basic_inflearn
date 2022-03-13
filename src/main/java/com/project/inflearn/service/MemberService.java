package com.project.inflearn.service;

import com.project.inflearn.domain.Member;
import com.project.inflearn.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // 서비스 클래스는 비즈니스와 밀접하게 작성해야한다. 네이밍 또한 밀접하게 해야한다.
    // repository는 서비스 보다는 더 유연하게 작성한다.

    /**
     * 회원 가입
     * */
    public Long join(Member member){
        // 같은 이름 중복 체크
        // Optional로 감싸면 편한 몇가지의 함수를 사용할 수 있다.
        // 그러나 바로 Optional로 받는 것은 권장하지 않음 -> 가독성? 데이터의 혼동성?
        // Optional<Member> result = memberRepository.findByName(member.getName());
        // 아래와 같이 변경할 수 있다.
        // memberRepository.findByName(member.getName())
        //         .ifPresent(m -> {
        //             throw new IllegalStateException("이미 존재하는 회원입니다.");
        //         });
        // findByName 이후 로직이 더 그려지는 경우 함수로 빼는 것이 좋을 수도 있다.
        // 단축키 command + t
        // 추가적으로 할당 변수 단축키는 option + command + v
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    // Optional 참고 사이트 http://www.tcpschool.com/java/java_stream_optional

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    /**
     * 전체 회원 조회
     * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 회원 조회
     * */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
