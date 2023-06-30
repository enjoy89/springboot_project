package com.example.springboot_project.web.member;

import com.example.springboot_project.domain.member.model.Member;
import com.example.springboot_project.service.member.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Create
    @PostMapping("/member/new")
    public ResponseEntity<Long> create(@RequestBody Member member) {
        Long memberId = memberService.joinMember(member);
        return new ResponseEntity<>(memberId, HttpStatus.OK);
    }

    // Read
    @GetMapping("/member/{id}")
    public ResponseEntity<Member> read(@PathVariable Long id) {
        Member member = memberService.findMember(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    // Read All
    @GetMapping("/members")
    public ResponseEntity<Collection<Member>> readAll() {
        Collection<Member> members = memberService.findAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // Update
    @PutMapping("/member/update/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody Member member) {
        Long memberId = memberService.updateMember(id, member);
        return new ResponseEntity<>(memberId, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/member/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        Long memberId = memberService.deleteMember(id);
        return new ResponseEntity<>(memberId, HttpStatus.OK);
    }
}
