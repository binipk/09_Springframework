package com.ohgiraffers.section01.autowired.subsection01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /*
         * ✅ Spring IoC 컨테이너 생성
         * - base package: com.ohgiraffers.section01
         * - 해당 경로의 클래스들 중 @Component, @Service, @Repository 붙은 애들을 Bean으로 등록
         */
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        /*
         * 🧾 스프링 컨테이너에 등록된 Bean 이름들 출력
         */
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println("definitionName: " + definitionName);
        }

        /*
         * ✅ BookService Bean을 가져와서 사용
         * - 이 객체는 스프링이 생성하고, @Autowired도 적용해준 상태임
         */
        BookService bookService = context.getBean("bookServiceField", BookService.class);

        // 📘 특정 책 조회
        System.out.println(bookService.selectBookBySequence(1));

        // 📗 전체 책 목록 조회
        System.out.println(bookService.selectAllBooks());

        /*
         * ❌ 아래 코드는 작동 안 됨!
         * - 스프링이 아닌 직접 new로 만든 객체는 @Autowired가 적용되지 않아서 내부에 bookDAO가 null임
         * - 실행하면 NullPointerException 발생함
         */
        BookService bookService2 = new BookService();
        System.out.println(bookService2.selectAllBooks()); // 💥 NullPointerException
    }
}
