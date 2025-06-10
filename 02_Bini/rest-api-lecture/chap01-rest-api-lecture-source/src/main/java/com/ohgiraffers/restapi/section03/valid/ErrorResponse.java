package com.ohgiraffers.restapi.section03.valid;

public class ErrorResponse {
    private String code;
    private String description;
    private String detail;

    // 👇 이 생성자 추가!
    public ErrorResponse(String code, String description, String detail) {
        this.code = code;
        this.description = description;
        this.detail = detail;
    }

    public String getCode() { return code; }
    public String getDescription() { return description; }
    public String getDetail() { return detail; }
}
