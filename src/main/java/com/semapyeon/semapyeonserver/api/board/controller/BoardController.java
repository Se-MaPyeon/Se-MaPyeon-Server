package com.semapyeon.semapyeonserver.api.board.controller;

import com.semapyeon.semapyeonserver.api.board.dto.request.WriteBoardRequest;
import com.semapyeon.semapyeonserver.api.board.dto.response.BoardsResponse;
import com.semapyeon.semapyeonserver.api.board.service.BoardService;
import com.semapyeon.semapyeonserver.api.common.APISuccessResponse;
import com.semapyeon.semapyeonserver.api.common.SuccessMessage;
import com.semapyeon.semapyeonserver.common.auth.PrincipalHandler;
import com.semapyeon.semapyeonserver.enums.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BoardController {

    private final BoardService boardService;
    private final PrincipalHandler principalHandler;

    @GetMapping("/boards")
    public ResponseEntity<APISuccessResponse<BoardsResponse>> getBoards(
            @RequestParam(name = "categoryName") Category categoryName
    ) {

        return ResponseEntity.status(HttpStatus.OK).body(APISuccessResponse.of(SuccessMessage.GET_BOARDS_SUCCESS.getMessage(), SuccessMessage.GET_BOARDS_SUCCESS.getStatus(), boardService.getBoards(categoryName)));
    }

    @PostMapping("/board")
    public ResponseEntity<APISuccessResponse<Void>> writeBoard(
            @RequestBody WriteBoardRequest writeBoardRequest
    ) {
        Long memberId = principalHandler.getMemberIdFromPrincipal();
        boardService.writeBoard(memberId, writeBoardRequest);
        return ResponseEntity.status(HttpStatus.OK).body(APISuccessResponse.of(SuccessMessage.WRITE_BOARD_SUCCESS.getMessage(), SuccessMessage.WRITE_BOARD_SUCCESS.getStatus(), null));
    }

    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<APISuccessResponse<Void>> deleteBoard(
            @PathVariable(name = "boardId") Long boardId
    ) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(APISuccessResponse.of(SuccessMessage.DELETE_BOARD_SUCCESS.getMessage(), SuccessMessage.DELETE_BOARD_SUCCESS.getStatus(), null));
    }

}
