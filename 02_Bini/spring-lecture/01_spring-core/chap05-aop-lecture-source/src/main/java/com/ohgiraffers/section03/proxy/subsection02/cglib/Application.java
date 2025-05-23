package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.Student;
import com.ohgiraffers.section03.proxy.common.StudentImpl;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {

        // 1. 실제 대상 객체
        Student target = new StudentImpl();

        // 2. 프록시 핸들러 설정
        Handler handler = new Handler(target);

        // 3. 프록시 객체 생성
        Student proxy = (Student) Proxy.newProxyInstance(
                Student.class.getClassLoader(),
                new Class[]{Student.class},
                handler
        );

        // 4. 프록시 객체 메서드 호출
        proxy.study(16);  // → Handler에서 가로채서 로그 출력 포함됨
    }
}
