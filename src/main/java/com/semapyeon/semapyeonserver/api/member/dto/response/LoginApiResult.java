package com.semapyeon.semapyeonserver.api.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginApiResult {
    private String authenticator;
    private LoginApiBody body;
    private String code; //실패 시 이 아이가 "auth_failed"
}
