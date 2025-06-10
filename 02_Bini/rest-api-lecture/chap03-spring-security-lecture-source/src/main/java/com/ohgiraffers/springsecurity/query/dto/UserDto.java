package com.ohgiraffers.springsecurity.query.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {

    private String username; // username 이라고 많이 씀
    private String password;
}
