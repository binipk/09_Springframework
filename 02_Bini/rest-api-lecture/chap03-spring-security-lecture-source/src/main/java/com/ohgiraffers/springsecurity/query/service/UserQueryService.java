package com.ohgiraffers.springsecurity.query.service;

import com.ohgiraffers.springsecurity.query.dto.UserDetailResponse;
import com.ohgiraffers.springsecurity.query.dto.UserDto;
import com.ohgiraffers.springsecurity.query.dto.UserListResponse;
import com.ohgiraffers.springsecurity.query.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserMapper userMapper;

    public UserDetailResponse getUserDetail(String username) {
        UserDto userDto = Optional.ofNullable(
                userMapper.findUserByUsername(username)
        ).orElseThrow(() -> new RuntimeException("유저 못찾음"));

        return UserDetailResponse.builder()
                .user(userDto)
                .build();
    }

    public UserListResponse getAllUsers() {
        List<UserDto> users = userMapper.findAllUsers();
        return UserListResponse.builder().users(users).build();
    }
}
