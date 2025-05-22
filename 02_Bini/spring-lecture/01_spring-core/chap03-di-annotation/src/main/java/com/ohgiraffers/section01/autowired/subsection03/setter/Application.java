package com.ohgiraffers.section01.autowired.subsection03.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /*
         * ✅ ApplicationContext 생성 (Spring IoC 컨테이너)
         * - 지정한 패키지 경로 아래에 있는 @Component, @Service, @Repository 등을 가진 클래스들을
         *   자동으로 스캔하여 Bean으로 등록
         */
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        /*
         * 🧾 등록된 Bean ID들 확인 (컨테이너에 어떤 Bean이 들어있는지 출력)
         */
        String[] beanNames = context.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println("beanName = " + name);
        }

        /*
         * 📕 BookService Bean 사용 테스트
         * - setter 방식으로 주입된 BookDAO 내부 데이터 확인
         */
        BookService bookService =
                context.getBean("bookServiceSetter", BookService.class);

        System.out.println(bookService.selectBookBySequence(1));
        System.out.println(bookService.selectAllBooks());
    }
}
