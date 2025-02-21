package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member>store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        memeber.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)) ;
    }

    @Override
    public Optional<Member> findByName(String name) {
        store.values().stream().filter(member -> member.getName().equals(name)).findAny();
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
