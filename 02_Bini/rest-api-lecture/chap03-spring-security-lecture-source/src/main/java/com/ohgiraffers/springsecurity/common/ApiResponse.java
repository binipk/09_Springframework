package com.ohgiraffers.springsecurity.common;

public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String message;

    // 성공 응답 정적 메서드
    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = true;
        response.data = data;
        response.message = "요청이 성공했습니다.";
        return response;
    }

    // 실패 응답도 필요할 수 있음
    public static <T> ApiResponse<T> fail(String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = false;
        response.message = message;
        return response;
    }

    // getter/setter 등 생략
}

