package com.semapyeon.semapyeonserver.member.service;

import com.semapyeon.semapyeonserver.member.dto.LoginRequest;
import com.semapyeon.semapyeonserver.member.dto.Member;
import com.semapyeon.semapyeonserver.member.dto.MemberResponse;

public interface MemberService {
    MemberResponse joinMember(LoginRequest loginRequest);
    MemberResponse loginMember(LoginRequest loginRequest);
}
