package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.autowired.common.BookDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /*
         * ✅ ApplicationContext 생성 (Spring IoC 컨테이너)
         * - "com.ohgiraffers.section01" 경로를 기준으로
         *   그 하위 패키지에 있는 @Component, @Service, @Repository, @Configuration
         *   같은 어노테이션이 붙은 클래스를 자동으로 스캔해서 Bean으로 등록함
         */
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "com.ohgiraffers.section01"
                );

        /*
         * 🧾 등록된 Bean 이름 목록 출력
         * - 스프링 컨테이너에 등록된 Bean ID들을 확인할 수 있음
         */
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println("definitionName = " + definitionName);
        }

        /*
         * 📕 생성자 주입 방식으로 등록된 BookService 사용
         * - bookServiceConstructor라는 이름으로 등록됨 (@Service("bookServiceConstructor"))
         */
        BookService bookService =
                context.getBean("bookServiceConstructor", BookService.class);

        // 📘 특정 도서 조회
        System.out.println(bookService.selectBookBySequence(1));

        // 📗 전체 도서 목록 조회
        System.out.println(bookService.selectAllBooks());
        
        // IOC 컨테이너 없이 코드를 테스트할 때 생성자를 통해 BookDAO 객체를 전달하여 처리 가능
        BookService bookService2 = new BookService(new BookDAOImpl());
        System.out.println(bookService2.selectAllBooks());
    }
}
