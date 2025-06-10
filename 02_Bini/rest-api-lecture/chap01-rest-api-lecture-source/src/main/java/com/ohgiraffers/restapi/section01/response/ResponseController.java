package com.ohgiraffers.restapi.section01.response;

import com.ohgiraffers.restapi.section02.responseentity.ResponseMessage;
import com.ohgiraffers.restapi.section02.responseentity.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/response")
public class ResponseController {

    private List<UserDTO> users;

    public ResponseController() {
        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "유관순"));
        users.add(new UserDTO(2, "user02", "pass02", "홍길동"));
        users.add(new UserDTO(3, "user03", "pass03", "이순신"));
    }

    // POST - 사용자 등록
    @PostMapping("/users")
    public ResponseEntity<ResponseMessage> registUser(@RequestBody UserDTO userDTO) {
        int lastUserNo = users.get(users.size() - 1).getNo();
        userDTO.setNo(lastUserNo + 1);
        users.add(userDTO);

        URI location = URI.create("/response/users/" + userDTO.getNo());
        return ResponseEntity.created(location).build();
    }

    // GET - 전체 사용자 조회
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    // GET - 사용자 번호로 조회
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) {
        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .orElse(null);

        if (foundUser == null) {
            return new ResponseEntity<>(
                    new ResponseMessage(404, "사용자 없음", null),
                    HttpStatus.NOT_FOUND
            );
        }

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user", foundUser);

        return new ResponseEntity<>(
                new ResponseMessage(200, "조회 성공", responseMap),
                HttpStatus.OK
        );
    }

    // 문자열 응답 예제
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    // 객체(Object) 응답 예제
    @GetMapping("/message")
    public Message getMessage() {
        return new Message(200, "메세지를 응답합니다.");
    }

    // List 응답 예제
    @GetMapping("/list")
    public List<String> getList() {
        return List.of("사과", "바나나", "복숭아");
    }

    // Map 응답 예제
    @GetMapping("/map")
    public Map<Integer, String> getMap() {
        List<Message> messageList = List.of(
                new Message(200, "정상 응답"),
                new Message(404, "페이지를 찾을 수 없습니다"),
                new Message(500, "개발자의 잘못입니다")
        );
        return messageList.stream()
                .collect(Collectors.toMap(Message::getHttpStatusCode, Message::getMessage));
    }

    // ResponseEntity 응답 예제
    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity() {
        return ResponseEntity.ok(new Message(123, "hello world"));
    }

    // 커스텀 헤더 응답 예제
    @GetMapping("/headers")
    public ResponseEntity<String> customHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "이건_내가_만든_헤더");
        return new ResponseEntity<>("헤더 포함 응답입니다", headers, HttpStatus.OK);
    }

    // 빈 응답 예제
    @GetMapping("/no-content")
    public ResponseEntity<Void> noContent() {
        return ResponseEntity.noContent().build();
    }

    // 복잡한 응답 예제
    @GetMapping("/complex")
    public ResponseEntity<List<Message>> complexResponse() {
        List<Message> messages = List.of(
                new Message(200, "성공 메시지"),
                new Message(400, "잘못된 요청"),
                new Message(401, "인증 실패")
        );
        return ResponseEntity.ok(messages);
    }

    // 이미지 응답 예제
    @GetMapping(value="/image", produces=MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage() throws IOException {
        return getClass().getResourceAsStream("/images/spring.png").readAllBytes();
    }
}
