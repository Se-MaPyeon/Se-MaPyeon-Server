package com.semapyeon.semapyeonserver.member.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberResponse {
    private String studentId;
    private String major;
    private String name;
}
