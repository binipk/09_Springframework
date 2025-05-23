package com.ohgiraffers.section02.annotation.common;

import org.springframework.stereotype.Component;

// Spring이 관리할 수 있도록 Bean으로 등록하는 애너테이션
@Component
public class Squiretle implements Pokemon {

    // Pokemon 인터페이스가 요구하는 공격 메서드를 구현
    @Override
    public void attack() {
        System.out.println("꼬부기 물대포 발사♒♒♒");
    }
}
