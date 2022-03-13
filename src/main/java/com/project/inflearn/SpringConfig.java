package com.project.inflearn;

import com.project.inflearn.repository.*;
import com.project.inflearn.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
// 수동으로 관리하고 싶을 떄 해당 어노테이션을 씀
// Component 어노테이션을 가지고 있다.
public class SpringConfig {

    @PersistenceContext // 문서에서는 선언을 해줘야한다고 함. 안해도 스프링에서 자동으로 주입해줌.
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

//    private DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

//        return new MemoryMemberRepository();

        // h2 데이터 베이스로 변경
        // 스프링이 빈으로 올려 놓은 dataSource를 외부에서 주입 받았다.
//        return new JdbcMemberRepository(dataSource);

//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
