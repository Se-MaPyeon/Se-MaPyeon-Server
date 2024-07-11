package com.semapyeon.semapyeonserver.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginApiBody {
    private String major;
    private String name;
}
