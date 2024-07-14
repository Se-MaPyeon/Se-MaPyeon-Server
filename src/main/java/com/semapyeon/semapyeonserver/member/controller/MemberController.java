package com.semapyeon.semapyeonserver.member.controller;

import com.semapyeon.semapyeonserver.member.dto.LoginRequest;
import com.semapyeon.semapyeonserver.member.dto.Member;
import com.semapyeon.semapyeonserver.member.dto.MemberResponse;
import com.semapyeon.semapyeonserver.member.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        MemberResponse member = memberService.loginMember(loginRequest); //전공, 이름, 학번을 담음(프론트가 필요할 정보들)

        //쿠키 설정 필요
        return ResponseEntity.created(URI.create("/api/v1/board"))
                .body(member);
    }
}
