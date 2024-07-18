package com.semapyeon.semapyeonserver.api.common;

public record APIErrorResponse(
        String message,
        int status
) {
    public static APIErrorResponse of(String message, int status) {
        return new APIErrorResponse(message, status);
    }
}
