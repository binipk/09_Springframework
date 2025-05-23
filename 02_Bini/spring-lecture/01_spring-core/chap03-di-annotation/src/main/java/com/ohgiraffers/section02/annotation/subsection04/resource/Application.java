package com.ohgiraffers.section02.annotation.subsection04.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        // ApplicationContext 생성: 지정한 패키지를 기준으로 Component 스캔하여 Bean 등록
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        // 현재 등록된 모든 Bean 이름 출력 (Spring이 관리 중인 객체 목록)
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println("definitionName = " + definitionName);
        }

        // 이 아래에 실제 비즈니스 로직을 수행할 코드가 있어야 효과가 있음!
        // 예: PokemonServiceResource를 가져와서 메서드 실행
    }
}
