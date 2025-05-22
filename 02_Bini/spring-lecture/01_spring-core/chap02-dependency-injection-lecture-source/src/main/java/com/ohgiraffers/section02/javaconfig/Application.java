package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ⚙️ Java Config 기반 Spring Application 실행 클래스
 * - 설정 클래스(ContextConfiguration)를 이용해 Bean을 등록하고, 꺼내서 사용하는 예제
 */
public class Application {

    public static void main(String[] args) {

        /*
         * 🧠 ApplicationContext (스프링 컨테이너) 생성
         * - AnnotationConfigApplicationContext는 Java 설정(@Configuration)을 읽는 IoC 컨테이너
         * - 전달한 클래스(ContextConfiguration)를 기준으로 Bean 등록
         */
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /*
         * 📦 현재 스프링 컨테이너에 등록된 Bean들의 이름을 출력
         */
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println("definitionName = " + definitionName);
        }

        /*
         * 🧾 등록된 Bean 중 "memberGenerator" 이름을 가진 Bean 꺼내기
         * - 두 번째 인자는 반환 타입 명시 (MemberDTO.class)
         */
        MemberDTO member = applicationContext.getBean("memberGenerator", MemberDTO.class);

        /*
         * 📤 Bean의 내부 객체(PersonalAccount)의 정보 출력
         */
        System.out.println(member.getPersonalAccount());
    }
}
