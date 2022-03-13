package com.project.inflearn.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
/**
 * 이제 EntityManager에 해당 객체가 등록된다.
 * jpa에서 접근 가능
 * */
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 자동으로 생성해줄 때는 IDENTITY를 사용
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
