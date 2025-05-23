package com.ohgiraffers.section02.annotation.common;

import org.springframework.stereotype.Component;

// @Component 애너테이션을 붙이면 이 클래스는 Spring이 관리하는 Bean(객체)으로 등록됨
@Component
public class charmander implements Pokemon {

    // Pokemon 인터페이스를 구현해서 attack 메서드를 오버라이딩함
    @Override
    public void attack() {
        System.out.println("파이리 불꽃 공격 🔥🔥");
    }
}
