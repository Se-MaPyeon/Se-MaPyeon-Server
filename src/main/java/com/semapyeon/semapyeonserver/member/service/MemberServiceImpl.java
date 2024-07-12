package com.semapyeon.semapyeonserver.member.service;

import com.semapyeon.semapyeonserver.member.dao.MemberRepository;
import com.semapyeon.semapyeonserver.member.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberResponse joinMember(LoginRequest loginRequest) {//컨트롤러는 @RequsetBody해서 바인딩 후 넘겨주지 않을까?
        LoginApiMember response = getLoginApiMember(loginRequest);
        LoginApiBody result = response.getResult().getBody();

        Member member = new Member(result.getMajor(), result.getName(), loginRequest.getId(), loginRequest.getPw());

        Member saveMember = memberRepository.save(member);
        return MemberResponse.builder()
                .major(saveMember.getMajor())
                .name(saveMember.getName())
                .studentId(saveMember.getStudentId())
                .build();
    }

    @Override
    public MemberResponse loginMember(LoginRequest loginRequest) {
        Member member = memberRepository.findByStudentId(loginRequest.getId())
                .filter(m -> m.getPw().equals(loginRequest.getPw()))
                .orElse(null);//회원이 존재하지 않는다면 null반환
        return MemberResponse.builder()
                .major(member.getMajor())
                .name(member.getName())
                .studentId(member.getStudentId())
                .build();
    }

    private LoginApiMember getLoginApiMember(LoginRequest loginRequest) {
        RestClient restClient = RestClient.create();
        return restClient.post()
                .uri("https://auth.imsejong.com/auth?method=DosejongSession")
                .body(loginRequest)
                .retrieve()
                .body(LoginApiMember.class);
    }

    private Member createMember(LoginRequest loginRequest) {
        return null;
    }

    private String createToken() {
        return null;
    }
}
