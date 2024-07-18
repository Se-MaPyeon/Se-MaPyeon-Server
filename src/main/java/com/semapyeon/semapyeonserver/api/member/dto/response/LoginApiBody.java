package com.semapyeon.semapyeonserver.api.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginApiBody {
    private String major;
    private String name;
}
