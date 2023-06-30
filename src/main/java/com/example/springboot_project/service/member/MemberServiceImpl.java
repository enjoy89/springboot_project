package com.example.springboot_project.service.member;

import com.example.springboot_project.domain.member.model.Member;
import com.example.springboot_project.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long joinMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Collection<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Long updateMember(Long id, Member member) {
        return memberRepository.update(id, member);
    }

    @Override
    public Long deleteMember(Long id) {
        return memberRepository.remove(id);
    }
}
