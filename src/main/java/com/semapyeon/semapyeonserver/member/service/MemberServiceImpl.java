package com.semapyeon.semapyeonserver.member.service;

import com.semapyeon.semapyeonserver.member.dto.LoginApiMember;
import com.semapyeon.semapyeonserver.member.dto.LoginRequest;
import com.semapyeon.semapyeonserver.member.dto.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Override
    public Member loginMember(LoginRequest loginRequest) {//컨트롤러는 @RequsetBody해서 바인딩 후 넘겨주지 않을까?
        RestClient restClient = RestClient.create();
        LoginApiMember response = restClient.post()
                .uri("https://auth.imsejong.com/auth?method=DosejongSession")
                .body(loginRequest)
                .retrieve()
                .body(LoginApiMember.class);
        return new Member();
    }
}
