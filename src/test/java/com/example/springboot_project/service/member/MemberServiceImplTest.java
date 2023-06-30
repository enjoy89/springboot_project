package com.example.springboot_project.service.member;

import com.example.springboot_project.domain.member.model.Member;
import com.example.springboot_project.domain.member.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

class MemberServiceImplTest {

    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());

    @Test
    @DisplayName("회원 가입 테스트")
    void joinMember() {
        // given
        Member member = new Member(1L, "memberA", "VIP");

        // when
        memberService.joinMember(member);
        Member findMember = memberService.findMember(member.getId());

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    @DisplayName("회원 조회 테스트")
    void findMembers() {
        // given
        Member member_A = new Member(1L, "memberA", "VIP");
        Member member_B = new Member(2L, "memberB", "GOLD");
        Member member_C = new Member(3L, "memberC", "VIP");

        memberService.joinMember(member_A);
        memberService.joinMember(member_B);
        memberService.joinMember(member_C);

        // when
        Collection<Member> members = memberService.findAll();

        // then
        Assertions.assertThat(members.size()).isEqualTo(3);

    }

    @Test
    @DisplayName("회원 수정 테스트")
    void updateMember() {
        // given
        Member member_A = new Member(1L, "memberA", "VIP");
        memberService.joinMember(member_A);

        // when
        Member member_new = new Member(1L, "memberD", "GPLD");
        memberService.updateMember(1L, member_new);

        // then
        Assertions.assertThat(member_new).isEqualTo(memberService.findMember(1L));

    }

    @Test
    @DisplayName("회원 삭제 테스트")
    void deleteMember() {
        // given
        Member member_A = new Member(1L, "memberA", "VIP");
        memberService.joinMember(member_A);

        // when
        memberService.deleteMember(1L);

        // then
        Assertions.assertThat(memberService.findMember(1L)).isNull();

    }
}