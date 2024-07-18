package com.semapyeon.semapyeonserver.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    ALL("전체"),
    EMPLOYMENT("취업"),
    DEGREE("학사"),
    SCHOLARSHIP("장학");

    private final String category;
}
