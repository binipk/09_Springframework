package com.ohgiraffers.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*@Autowired로 동일 타입의 빈이 여러개 찾아진 경우
 * 우선시 할 타입을 설정 (피카츄 너로 정했다 이런거지)*/

@Primary // Pokemon 타입 빈이 여러 개 있을 때 이 클래스를 기본으로 선택하라는 의미야
@Component // Spring이 이 클래스를 관리할 수 있게 Bean으로 등록
public class Pikachu implements Pokemon {

    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트!! ⚡⚡⚡⚡");
    }
}
