package com.semapyeon.semapyeonserver.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginApiMember {
    private String msg;
    private LoginApiResult result;
    private String version;
}