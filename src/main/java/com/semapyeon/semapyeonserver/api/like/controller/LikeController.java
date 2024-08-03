package com.semapyeon.semapyeonserver.api.like.controller;

import com.semapyeon.semapyeonserver.api.common.APISuccessResponse;
import com.semapyeon.semapyeonserver.api.common.SuccessMessage;
import com.semapyeon.semapyeonserver.api.like.service.LikeService;
import com.semapyeon.semapyeonserver.common.auth.PrincipalHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LikeController {

    private final PrincipalHandler principalHandler;
    private final LikeService likeService;

    @PostMapping("/like/{boardId}")
    public ResponseEntity<APISuccessResponse<Void>> createLike(
            @PathVariable(name = "boardId") Long boardId
    ) {
        Long memberId = principalHandler.getMemberIdFromPrincipal();
        likeService.createLike(memberId, boardId); //추천 저장 수행
        return ResponseEntity.status(HttpStatus.CREATED).body(APISuccessResponse.of(SuccessMessage.CREATE_LIKE_SUCCESS.getMessage(), SuccessMessage.CREATE_LIKE_SUCCESS.getStatus(), null));
    }

    @DeleteMapping("/like/{boardId}")
    public ResponseEntity<APISuccessResponse<Void>> deleteLike(
            @PathVariable(name = "boardId") Long boardId
    ) {
        Long memberId = principalHandler.getMemberIdFromPrincipal();
        likeService.deleteLike(memberId, boardId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(APISuccessResponse.of(SuccessMessage.DELETE_LIKE_SUCCESS.getMessage(), SuccessMessage.DELETE_LIKE_SUCCESS.getStatus(), null));
    }

    // 추천 수를 반환하는 엔드포인트 추가
    @GetMapping("/like/{boardId}/count")
    public ResponseEntity<APISuccessResponse<Integer>> getLikeCount(
            @PathVariable(name = "boardId") Long boardId
    ) {
        int likeCount = likeService.getLikeCount(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(APISuccessResponse.of(SuccessMessage.GET_LIKE_COUNT_SUCCESS.getMessage(), SuccessMessage.GET_LIKE_COUNT_SUCCESS.getStatus(), likeCount));
    }
}
