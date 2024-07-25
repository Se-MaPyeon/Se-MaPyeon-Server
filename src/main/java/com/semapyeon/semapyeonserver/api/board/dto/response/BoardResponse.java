package com.semapyeon.semapyeonserver.api.board.dto.response;

public record BoardResponse(
        Long boardId,
        String title,
        String content,
        String category,
        String updateAt,
        int likes
) {
    public static BoardResponse of(Long boardId, String title, String content, String category, String updateAt, int likes) {
        return new BoardResponse(boardId, title, content, category, updateAt, likes);
    }
}
