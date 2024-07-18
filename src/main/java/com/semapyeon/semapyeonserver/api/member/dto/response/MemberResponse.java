package com.semapyeon.semapyeonserver.api.member.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberResponse {
    private String studentId;
    private String major;
    private String name;
}
