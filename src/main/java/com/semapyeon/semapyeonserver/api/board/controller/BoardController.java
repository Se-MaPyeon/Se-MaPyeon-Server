package com.semapyeon.semapyeonserver.api.board.controller;

import com.semapyeon.semapyeonserver.api.board.dto.response.BoardResponse;
import com.semapyeon.semapyeonserver.api.board.dto.response.BoardsResponse;
import com.semapyeon.semapyeonserver.api.board.service.BoardService;
import com.semapyeon.semapyeonserver.api.common.APISuccessResponse;
import com.semapyeon.semapyeonserver.api.common.SuccessMessage;
import com.semapyeon.semapyeonserver.enums.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity<APISuccessResponse<BoardsResponse>> getBoards(
            @RequestParam(name = "categoryName") Category categoryName
    ) {

        return ResponseEntity.status(HttpStatus.OK).body(APISuccessResponse.of(SuccessMessage.GET_BOARDS_SUCCESS.getMessage(), SuccessMessage.GET_BOARDS_SUCCESS.getStatus(), boardService.getBoards(categoryName)));
    }

}
