package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // 📦 스프링 컨테이너 생성: 지정한 패키지에서 컴포넌트 스캔 (@Component, @Service 등)
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        // 🧾 등록된 모든 Bean 이름 출력 (디버깅/확인용)
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println("definitionName = " + name);
        }

        // 🎯 memberService Bean 가져오기
        MemberService memberService = context.getBean(MemberService.class);

        // 👥 전체 회원 조회
        System.out.println("==== 전체 회원 목록 ====");
        System.out.println(memberService.selectMembers());

        // 🔍 ID가 1인 회원 조회
        System.out.println("==== ID가 1인 회원 조회 ====");
        System.out.println(memberService.selectMember(1L));
    }
}
