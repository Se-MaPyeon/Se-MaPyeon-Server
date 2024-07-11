package com.semapyeon.semapyeonserver.member.service;

import com.semapyeon.semapyeonserver.member.dto.LoginRequest;
import com.semapyeon.semapyeonserver.member.dto.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    @Override
    public Member loginMember(LoginRequest loginRequest) { //컨트롤러는 @RequsetBody해서 바인딩 후 넘겨주지 않을까?
        return new Member();
    }
}
