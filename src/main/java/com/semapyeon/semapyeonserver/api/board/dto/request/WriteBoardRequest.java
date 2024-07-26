package com.semapyeon.semapyeonserver.api.board.dto.request;

import com.semapyeon.semapyeonserver.enums.Category;

public record WriteBoardRequest(
        String title,
        String content,
        Category category
) {
    public static WriteBoardRequest of(String title, String content, Category category) {
        return new WriteBoardRequest(title, content, category);
    }
}
