package com.project.inflearn.controller;

import com.project.inflearn.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
// 스프링이 뜰 때 스프링 컨테이너에 이 클래스를 객체를 생성한 뒤 저장해 둔다.
// 빈에 등록 된다.
// 스프링 컨테이너 관리하에 있게 됨.
// 기본적으로 싱글톤 패턴으로 등록함. (하나를 공유)
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

}
