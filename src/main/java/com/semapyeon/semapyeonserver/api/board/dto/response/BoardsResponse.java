package com.semapyeon.semapyeonserver.api.board.dto.response;

import com.semapyeon.semapyeonserver.db.board.entity.Board;

import java.util.List;

public record BoardsResponse(
        List<BoardResponse> boards
) {
    public static BoardsResponse of(List<BoardResponse> boards) {
        return new BoardsResponse(boards);
    }
}
