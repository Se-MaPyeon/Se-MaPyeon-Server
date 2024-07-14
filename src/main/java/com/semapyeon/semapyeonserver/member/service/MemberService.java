package com.semapyeon.semapyeonserver.member.service;

import com.semapyeon.semapyeonserver.common.jwt.TokenResponse;
import com.semapyeon.semapyeonserver.member.dto.LoginRequest;
import com.semapyeon.semapyeonserver.member.dto.MemberResponse;

public interface MemberService {
    TokenResponse loginMember(LoginRequest loginRequest);
}
