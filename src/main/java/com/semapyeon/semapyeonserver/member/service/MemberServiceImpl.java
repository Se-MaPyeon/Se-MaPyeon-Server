package com.semapyeon.semapyeonserver.member.service;

import com.semapyeon.semapyeonserver.common.jwt.JwtTokenProvider;
import com.semapyeon.semapyeonserver.common.jwt.TokenResponse;
import com.semapyeon.semapyeonserver.member.dao.MemberRepository;
import com.semapyeon.semapyeonserver.member.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.NoSuchElementException;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    @Override
    public TokenResponse loginMember(LoginRequest loginRequest) {
        LoginApiMember student = getLoginApiMember(loginRequest);

        if (!studentOfSchool(student)) {
            throw new NoSuchElementException("No such student found"); //학생 아니면 오류던짐
        }

        LoginApiBody body = student.getResult().getBody();
        Member member = memberOfService(loginRequest, body); //db에 저장되어있지 않다면 저장 후 멤버 반환



        return TokenResponse.of(jwtTokenProvider.generateAccessToken(member.getId()), jwtTokenProvider.generateRefreshToken(member.getId()));
    }

    private LoginApiMember getLoginApiMember(LoginRequest loginRequest) {
        RestClient restClient = RestClient.create();
        return restClient.post()
                .uri("https://auth.imsejong.com/auth?method=DosejongSession")
                .body(loginRequest)
                .retrieve()
                .body(LoginApiMember.class);
    }

    private boolean studentOfSchool(LoginApiMember loginApiMember) {
        return loginApiMember.getResult().getCode().equals("success");
    }

    private Member memberOfService(LoginRequest loginRequest, LoginApiBody loginApiBody) { //db에 없다면 저장
        Optional<Member> member = memberRepository.findByStudentId(loginRequest.getId());
        if (member.isEmpty()) {
            Member saveMember = new Member(loginApiBody.getMajor(), loginApiBody.getName(),
                    loginRequest.getId(), loginRequest.getPw());
            memberRepository.save(saveMember);
            return saveMember;
        }
        return member.get();
    }
}
