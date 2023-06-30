package com.example.springboot_project.domain.member.repository;

import com.example.springboot_project.domain.member.model.Member;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private final Map<Long, Member> members = new HashMap<>();  // <id, member>

    @Override
    public Long save(Member member) {
        members.put(member.getId(), member);
        return member.getId();
    }

    @Override
    public Member findById(Long id) {
        return members.get(id);
    }

    @Override
    public Collection<Member> findAll() {
        return members.values();
    }

    @Override
    public Long update(Long id, Member member) {
        return members.replace(id, member).getId();
    }

    @Override
    public Long remove(Long id) {
        return members.remove(id).getId();
    }
}
