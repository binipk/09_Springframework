package com.ohgiraffers.springsecurity.auth.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginRequest {

    private final String username; // username 이라고 많이 씀
    private final String password;
}
