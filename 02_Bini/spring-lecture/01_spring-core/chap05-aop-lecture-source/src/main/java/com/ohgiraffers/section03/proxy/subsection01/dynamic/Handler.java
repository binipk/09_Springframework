package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 동적 프록시에서 사용하는 InvocationHandler 구현 클래스
 * - Student 객체의 메서드 호출을 가로채서 전/후 부가작업을 수행
 */
public class Handler implements InvocationHandler {

    private final Student student;  // 실제 호출 대상 객체 (타겟 오브젝트)

    public Handler(Student student) {
        this.student = student;     // 타겟 객체 주입
    }

    /**
     * 프록시 메서드가 호출되면 이 invoke() 메서드가 대신 실행됨
     * - method: 호출된 메서드 객체
     * - args: 전달된 인자들
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("=== 공부가 너무 하고 싶어요 ===");  // 호출 전 부가 로직

        System.out.println("호출 대상 메서드: " + method.getName());  // 어떤 메서드가 호출됐는지 로그

        // 전달 인자 출력
        if (args != null) {
            for (Object arg : args) {
                System.out.println("전달 인자: " + arg);
            }
        }

        // 실제 타겟 객체의 메서드 실행
        Object returnValue = method.invoke(student, args);

        System.out.println("=== 공부를 마치고 정리를 위해서 수면 학습을 시작 ===");  // 호출 후 부가 로직

        return returnValue;  // 프록시의 메서드 결과를 호출자에게 반환
    }
}
