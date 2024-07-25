package com.semapyeon.semapyeonserver.api.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    GET_BOARDS_SUCCESS("게시글 리스트 조회 성공", HttpStatus.OK.value()),
    GET_MY_BOARDS_SUCCESS("마이페이지 조회 성공", HttpStatus.OK.value()),
    WRITE_BOARD_SUCCESS("게시글 작성 성공", HttpStatus.CREATED.value()),
    DELETE_BOARD_SUCCESS("게시글 삭제 성공", HttpStatus.NO_CONTENT.value()),
    CREATE_LIKE_SUCCESS("추천 성공", HttpStatus.CREATED.value()),
    DELETE_LIKE_SUCCESS("추천 취소 성공", HttpStatus.NO_CONTENT.value());

    private final String message;
    private final int status;
}
