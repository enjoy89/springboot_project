package com.example.springboot_project.service.member;

import com.example.springboot_project.domain.member.model.Member;

import java.util.Collection;

public interface MemberService {

    // Create
    Long joinMember(Member member);

    // Read
    Member findMember(Long id);
    Collection<Member> findAll();

    // Update
    Long updateMember(Long id, Member member);

    // Delete
    Long deleteMember(Long id);
}
