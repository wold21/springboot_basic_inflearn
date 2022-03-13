package com.project.inflearn.repository;

import com.project.inflearn.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    /**
     * SpringDataJpaMemberRepository라고 선언하면 (SpringData ... Repository) 스프링에서 인식하는 듯.
     */

    @Override
    Optional<Member> findByName(String name);

    /** 다만 해당 함수는 jpa에서 지원을 하지 못하기 때문에 구현해놓은 것인데 이런 함수는 프로젝트 마다 다르기 때문이다.
     * 그래서 sdj에서는 하나의 규칙을 제공에 이를 해결했다.
     * find + By + {원하는 값}(해당 타입 + {원하는 값})
     * find + By + {원하는 값}And{원하는 값}(해당 타입 + {원하는 값}, 해당 타입 + {원하는 값})
     * find + By + {원하는 값}Or{원하는 값}(해당 타입 + {원하는 값}, 해당 타입 + {원하는 값})
     * 많은 규칙들을 제공해 편리하게 사용하게 만들었다.
     */
}
