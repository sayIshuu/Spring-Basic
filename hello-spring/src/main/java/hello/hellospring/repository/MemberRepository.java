package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //Optional : 찾아오는 값이 null인경우를 예외처리하는 기능
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
