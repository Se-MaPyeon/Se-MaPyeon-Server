package com.semapyeon.semapyeonserver.api.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    GET_BOARDS_SUCCESS("게시글 리스트 조회 성공", HttpStatus.OK.value());

    private final String message;
    private final int status;
}
