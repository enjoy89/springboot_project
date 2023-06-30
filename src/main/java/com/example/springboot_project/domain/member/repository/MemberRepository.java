package com.example.springboot_project.domain.member.repository;

import com.example.springboot_project.domain.member.model.Member;

import java.util.Collection;

public interface MemberRepository {

    // Create
    Long save(Member member);

    // Read
    Member findById(Long id);
    Collection<Member> findAll();

    // Update
    Long update(Long id, Member member);

    // Delete
    Long remove(Long id);
}
