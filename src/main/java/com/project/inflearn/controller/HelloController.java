package com.project.inflearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody // http에 데이터를 그대로 넘긴다.
    public Hello helloApi(@RequestParam("name") String name){

        /**
         * 그런데 객체를 반환해야 할 때
         * 이전에는 viewResolver가 반환을 담당했다면
         * ResponseBody가 있는 이번에는 HttpMessageConverter가 작동한다.
         * 단순 문자형이라면 String Converter(StringHttpMessageConverter)
         * 객체형이라면 Json Converter(MappingJackson2HttpMessageConverter)를 반환한다.
         * -> jackson = 객체를 json으로 바꿔주는 라이브러리 중 하나.(구글은 Gson)
         * */
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        // getter setter
        // 자바 Bean 규약
        private String name;

        public String getName() {
            return name;
        }

        // property 접근 방식
        public void setName(String name) {
            this.name = name;
        }

    }

    /**
     * h2 database 셋팅
     * 8MB로 가벼운 실습용 DB
     * mysql기반이다.
     * */
}
