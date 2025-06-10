package com.ohgiraffers.springsecurity.command.dto.request;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserCreateRequest {

    private final String username; // username 이라고 많이 씀
    private final String password;
}
