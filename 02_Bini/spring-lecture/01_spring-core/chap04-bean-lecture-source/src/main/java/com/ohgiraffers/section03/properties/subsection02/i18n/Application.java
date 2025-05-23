package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // 한국어 메시지
        String error404KR = context.getMessage("error.404", null, Locale.KOREA);
        String error500KR = context.getMessage("error.500", new Object[]{"여러분", new Date()}, Locale.KOREA);

        // 영어 메시지
        String error404US = context.getMessage("error.404", null, Locale.US);
        String error500US = context.getMessage("error.500", new Object[]{"you", new Date()}, Locale.US);

        // 중국어 메시지
        String error404CN = context.getMessage("error.404", null, Locale.CHINA);
        String error500CN = context.getMessage("error.500", new Object[]{"你", new Date()}, Locale.CHINA);

        System.out.println(error404KR);
        System.out.println(error500KR);
        System.out.println(error404US);
        System.out.println(error500US);
        System.out.println(error404CN);
        System.out.println(error500CN);
    }
}
