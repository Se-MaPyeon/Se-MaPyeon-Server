package com.semapyeon.semapyeonserver.api.member.dto.response;

import com.semapyeon.semapyeonserver.api.member.dto.response.LoginApiResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginApiMember {
    private String msg;
    private LoginApiResult result;
    private String version;
}
