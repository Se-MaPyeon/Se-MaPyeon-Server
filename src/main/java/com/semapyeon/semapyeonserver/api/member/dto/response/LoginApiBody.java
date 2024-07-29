package com.semapyeon.semapyeonserver.api.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginApiBody {
    private String major;
    private String name;
}
