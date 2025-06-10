package com.ohgiraffers.restapi.section02.responseentity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entity")
public class ResponseEntitycontroller {

    private List<UserDTO> users;

    public ResponseEntitycontroller() {
        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "유관순"));
        users.add(new UserDTO(2, "user02", "pass02", "홍길동"));
        users.add(new UserDTO(3, "user03", "pass03", "이순신"));
    }

    @PutMapping("/users/{userNo}")
    public ResponseEntity<Void> modifyUser(
            @PathVariable int userNo, @RequestBody UserDTO userDTO
    ) {
        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        foundUser.setPwd(userDTO.getPwd());
        foundUser.setName(userDTO.getName());

        return ResponseEntity.created(URI.create("/entity/users/" + userNo)).build();
    }

    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userNo) {
        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        users.remove(foundUser);

        return ResponseEntity.noContent().build();  // 204 No Content
    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<UserDTO> getUserByNo(@PathVariable int userNo) {
        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseEntity.ok(foundUser);
    }

}
