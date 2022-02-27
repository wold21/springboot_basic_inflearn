package com.project.inflearn;

import com.project.inflearn.repository.MemberRepository;
import com.project.inflearn.repository.MemoryMemberRepository;
import com.project.inflearn.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 수동으로 관리하고 싶을 떄 해당 어노테이션을 씀
// Component 어노테이션을 가지고 있다.
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
