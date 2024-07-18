package com.semapyeon.semapyeonserver.api.common;

public record APISuccessResponse<T>(
        String message,
        int status,
        T data
) {
    public static <T> APISuccessResponse<T> of(String message, int status, T data) {
        return new APISuccessResponse<T>(message, status, data);
    }
}
