package com.project.inflearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello");
        return "hello";
        // viewResolver가 화면을 찾아서 처리함
        // 스프링 부트 템플릿 엔진 기본 viewName 매핑
        // `resources:templates/` + {ViewName} + `.html`
        // 클래스가 로딩될 때 경로가 세팅됨.
    }
}
