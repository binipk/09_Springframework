package com.ohgiraffers.section03.proxy.subsection02.cglib;

import com.ohgiraffers.section03.proxy.common.Student;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    private final Student student;  // 타겟 객체

    public Handler(Student student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("📚 공부 전에 준비 운동!");
        if (args != null && args.length > 0) {
            System.out.println("⮞ 전달된 인자: " + args[0]);
        }

        Object result = method.invoke(student, args);  // 실제 메서드 실행

        System.out.println("😴 공부 후 복습 및 수면 학습!");
        return result;
    }
}
