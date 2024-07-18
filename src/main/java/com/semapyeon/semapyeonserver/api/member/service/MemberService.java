package com.semapyeon.semapyeonserver.api.member.service;

import com.semapyeon.semapyeonserver.api.member.dto.request.LoginRequest;
import com.semapyeon.semapyeonserver.common.jwt.TokenResponse;

public interface MemberService {
    TokenResponse loginMember(LoginRequest loginRequest);
}
