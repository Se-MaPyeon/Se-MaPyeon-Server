package com.semapyeon.semapyeonserver.member.service;

import com.semapyeon.semapyeonserver.member.dto.LoginRequest;
import com.semapyeon.semapyeonserver.member.dto.MemberResponse;

public interface MemberService {
    MemberResponse loginMember(LoginRequest loginRequest);
}
