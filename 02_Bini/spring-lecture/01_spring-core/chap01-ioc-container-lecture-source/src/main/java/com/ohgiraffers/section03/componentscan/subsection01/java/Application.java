package com.ohgiraffers.section03.componentscan.subsection01.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main(String[] args) {

        /*
         @ComponentScan?
         → 스프링이 "이 패키지부터 아래에 있는 클래스들 중에 @Component 같은 거 붙어 있는 애들 있나~?"
            하고 자동으로 찾아서 Bean으로 등록해주는 기능이야.

         - MemberDAO 클래스에 @Component를 붙여놨다면,
           @ComponentScan이 설정된 base-package 범위 안에 있을 경우 자동 등록됨.

         🎯 참고: @Component의 특별한 버전들
         - @Controller: 웹 요청 처리
         - @Service: 서비스 로직 처리
         - @Repository: DB 연동 처리
         - @Configuration: 설정 클래스
        */

        // 📦 Annotation 기반으로 스프링 컨테이너를 생성하고 설정 클래스 전달
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConfigurationContext.class);

        // 📦 현재 스프링 컨테이너에 등록된 모든 Bean 이름들을 가져옴
        String[] definitionNames = applicationContext.getBeanDefinitionNames();

        // 🖨 하나씩 출력해서 어떤 빈들이 등록됐는지 확인
        for (String definitionName : definitionNames) {
            System.out.println("등록된 bean 이름: " + definitionName);
        }
    }
}
