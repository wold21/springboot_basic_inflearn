package com.project.inflearn.repository;

import com.project.inflearn.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    /**
     * JPA는 EntityManager로 모든걸 동작한다.
     * jpa를 디펜던시로 사용하면 스프링 부트가 자동으로 EntityManager를 생성해줌.
     * 그리고 서비스 객체에 항상 @Transactional이 있어야한다.
     * */
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        // jpql이라는 객체 지향 언어를 사용해야함 sql이랑 비슷
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // jpql이라는 객체 지향 언어를 사용해야함 sql이랑 비슷
        // 객체로 쿼리를 날린다. (Member as m)
        // select m은 멤버 객체를 셀렉트 한다.
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
