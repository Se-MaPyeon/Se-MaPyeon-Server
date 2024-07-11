package com.semapyeon.semapyeonserver.member.service;

import com.semapyeon.semapyeonserver.member.dto.LoginRequest;
import com.semapyeon.semapyeonserver.member.dto.Member;

public interface MemberService {
    Member loginMember(LoginRequest loginRequest);
}
