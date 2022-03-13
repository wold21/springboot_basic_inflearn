package com.project.inflearn.service;

import com.project.inflearn.domain.Member;
import com.project.inflearn.repository.MemberRepository;
import com.project.inflearn.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** @SpringBootTest -> 실제로 스프링을 다 띄운다. 설정까지 모두 */
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    /**
     * 진짜 좋은 테스트는 통합테스트가 아니라 단위 테스트를 잘 만드는 것이 중요하다.
     * 스프링 컨테이너까지 올려 테스트 하는 것은 정확하지 않을 수 있다.
     * (테스트를 스프링이 아닌 본인이 직접 설계하고 돌리는 것이 좋은 효과를 낼 수 있다는 말 같다.)
     * (정성을 들여라.)
     * */

    @Test
    void join() {
        //테스트 코드의 구분
        //given
        Member member = new Member();
        member.setName("남바3");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

        /**
         * 위의 테스트를 실행 했을 때 user01이라는 유저가 실제로 DB에 insert 된다.
         * 따라서 반복 테스트가 불가해지고 그것을 처리해주기 위해
         * @BeforeEach나 @AfterEach를 써서 차후 작업을 해줘야한다.
         *
         * 그러나 스프링에서는 이를 편하게 만들어 주는 어노테이션이 있다.
         * 바로 @Transactional이다, 테스트가 끝나면 깔끔하게 롤백을 해주는 친구이다.
         * 한 테스트가 끝날 때마다 관여하며 다음 테스트에 영향을 주지 않는다. 아주 편리하다.
         * */
    }

    @Test
    public void overlapJoin(){
        //given
        Member member1 = new Member();
        member1.setName("user03");

        Member member2 = new Member();
        member2.setName("user03");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

/*        try {
            memberService.join(member2);
            fail("중복된 ID가 있습니다.");
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123123");
        }*/


        //then
    }
}
