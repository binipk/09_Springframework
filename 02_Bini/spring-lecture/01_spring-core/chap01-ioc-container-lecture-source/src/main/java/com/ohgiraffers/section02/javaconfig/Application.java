package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        // ✅ Java 기반 설정 클래스(ConfigurationContext)를 읽어 IoC 컨테이너(ApplicationContext)를 생성
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConfigurationContext.class);

        // ✅ 컨테이너에서 "member"라는 이름의 Bean을 가져옴 (타입은 MemberDTO)
        MemberDTO member = applicationContext.getBean("member", MemberDTO.class);

        // ✅ 객체가 잘 생성되었는지 출력해봄
        System.out.println("member = " + member);
    }
}
