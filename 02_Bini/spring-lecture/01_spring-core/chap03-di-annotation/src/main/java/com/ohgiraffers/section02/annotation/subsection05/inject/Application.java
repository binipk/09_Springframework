package com.ohgiraffers.section02.annotation.subsection05.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        // 현재 등록된 Bean 목록 출력 (디버깅용)
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println("definitionName = " + definitionName);
        }

        // subsection05.inject 패키지의 PokemonService 가져오기
        PokemonService pokemonService = context.getBean(PokemonService.class);
        pokemonService.pokemonAttack();  // "파이리 불꽃 공격 🔥🔥" 출력 예상
    }
}
