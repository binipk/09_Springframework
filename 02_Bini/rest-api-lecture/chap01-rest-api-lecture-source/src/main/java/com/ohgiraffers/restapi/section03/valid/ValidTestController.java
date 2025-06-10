package com.ohgiraffers.restapi.section03.valid;

import com.ohgiraffers.restapi.section02.responseentity.UserDTO;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/valid")
public class ValidTestController {

    @GetMapping("/users/{userNo}")
    public ResponseEntity<?> findByUserNo(@PathVariable("userNo") int userNo) {
        boolean check = true;
        if (check) {
            throw new UserNotFoundException("회원 정보를 찾을 수 없습니당!");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@Validated @RequestBody UserDTO userDTO) {
        return ResponseEntity.created(URI.create("/valid/users/1")).build();
    }
}
