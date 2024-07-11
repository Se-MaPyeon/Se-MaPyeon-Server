package com.semapyeon.semapyeonserver.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginApiResult {
    private String authenticator;
    private LoginApiBody body;
    private String code;
}
