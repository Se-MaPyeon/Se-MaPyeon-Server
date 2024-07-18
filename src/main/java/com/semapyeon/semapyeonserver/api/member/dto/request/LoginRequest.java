package com.semapyeon.semapyeonserver.api.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequest {
    private String id;
    private String pw;
}
