package com.semapyeon.semapyeonserver.member.controller;

import com.semapyeon.semapyeonserver.member.dto.LoginRequest;
import com.semapyeon.semapyeonserver.member.dto.Member;
import com.semapyeon.semapyeonserver.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/v1/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        Member member = memberService.loginMember(loginRequest);
        log.info("member's major = {}, member's name ={}", member.getMajor(), member.getName());
        return null; //일단 빨간줄 없애려고..
    }
}
