package com.project.inflearn.controller;

import com.project.inflearn.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
// 스프링이 뜰 때 스프링 컨테이너에 이 클래스를 객체를 생성한 뒤 저장해 둔다.
// 빈에 등록 된다.
// 스프링 컨테이너 관리하에 있게 됨.
// 기본적으로 싱글톤 패턴으로 등록함. (하나를 공유)
// Controller는 수동으로 등록 할 수 없다.
public class MemberController {
    private final MemberService memberService;

    @Autowired
    // 스프링 빈에 있는 memberService 객체를 주입받는다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 스프링 빈을 등록하는 2가지 방법
    // 1. 컴포넌트 스캔방식 (Service, Repository, Controller는 @Component가 이미 할당 되어있다.)
    //   - 결론적으로 @Component가 있어야만 스프링이 구동될 때 빈으로써(객체를) 컨테이너에 등록을 해놓는다.
    // 2. 자바 코드로 직접 스프링 빈 등록하기
    //   - Config 클래스르 하나 만들고 어노테이션 @Configuration을 쓰고
    //   - 해당 클래스에 스프링 빈으로 등록하고 싶은 (스프링 관리하에, 스프링 컨테이너에) 객체들을 @Bean 어노테이션을 달아 객체를 생성하면(new) 된다.
    //   - 과거에는 xml로 등록하는 방식이었으나 현재는 거의 사용되지 않는 방식이다.


    // DI 주입 방식
    // 1. setter injection
    // 2. field injection
    // 3. constructor injection(의존관계 확립 이후에는 동적으로 변화할 경우가 거의 없으므로 생성자 주입을 사용한다.)

}
