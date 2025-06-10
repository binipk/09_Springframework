package com.ohgiraffers.restapi.section04.hateoas;

import com.ohgiraffers.restapi.section02.responseentity.UserDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/hateoas")
public class HateoasController {

    private List<UserDTO> users;

    public HateoasController() {
        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "유관순"));
        users.add(new UserDTO(2, "user02", "pass02", "홍길동"));
        users.add(new UserDTO(3, "user03", "pass03", "이순신"));
    }

    // 전체 유저 조회
    @GetMapping("/users")
    public ResponseEntity<CollectionModel<EntityModel<UserDTO>>> findAllUsers() {
        List<EntityModel<UserDTO>> userResources = users.stream()
                .map(user -> EntityModel.of(
                        user,
                        linkTo(methodOn(HateoasController.class).findUserByNo(user.getNo())).withSelfRel()
                ))
                .collect(Collectors.toList());

        Link selfLink = linkTo(methodOn(HateoasController.class).findAllUsers()).withSelfRel();

        return ResponseEntity.ok(CollectionModel.of(userResources, selfLink));
    }

    // 개별 유저 조회
    @GetMapping("/users/{userNo}")
    public ResponseEntity<EntityModel<UserDTO>> findUserByNo(@PathVariable int userNo) {
        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("해당 유저가 없습니다."));

        EntityModel<UserDTO> userResource = EntityModel.of(
                foundUser,
                linkTo(methodOn(HateoasController.class).findUserByNo(userNo)).withSelfRel(),
                linkTo(methodOn(HateoasController.class).findAllUsers()).withRel("all-users")
        );

        return ResponseEntity.ok(userResource);
    }
}
