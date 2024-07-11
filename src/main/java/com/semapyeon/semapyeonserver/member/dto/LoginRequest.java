package com.semapyeon.semapyeonserver.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequest {
    private String id;
    private String pw;
}
