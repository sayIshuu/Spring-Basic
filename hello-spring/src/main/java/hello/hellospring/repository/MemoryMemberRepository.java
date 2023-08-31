package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override

    public Member save(Member member) {
        member.setId(++sequence);   //id 변수는 시스템상에서 구분하기위해 사용하는 것 단순히 하나 늘려서 저장하는 코드
        store.put(member.getId(), member);  //<key, value> 해쉬맵
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //Optional 기능을 사용해서 null값일 때 예외처리
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //생성과 동시에 리턴
    }


    public void clearStore() {
        store.clear();
    }
}
