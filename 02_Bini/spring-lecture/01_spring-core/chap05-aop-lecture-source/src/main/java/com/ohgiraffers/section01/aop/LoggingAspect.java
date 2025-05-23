package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component  // 스프링이 이 클래스를 Bean으로 등록
@Aspect     // 이 클래스가 AOP 기능을 가진 Aspect임을 명시
public class LoggingAspect {

    /**
     * Pointcut 정의
     * - 대상: com.ohgiraffers.section01.aop 패키지 내 *Service 클래스의 모든 메서드
     * - 사용: 각 어드바이스(@Before 등)에서 공통 지점으로 참조
     */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut() {}

    /**
     * @Before: 대상 메서드 실행 전에 동작
     * - 호출된 대상 메서드, 인자 등의 정보를 출력
     * - 주로: 로깅, 권한 확인, 유효성 검사에 사용
     */
    @Before("logPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("📌 [Before] 메서드 실행 전");
        System.out.println("⮞ 대상 객체: " + joinPoint.getTarget());
        System.out.println("⮞ 호출 메서드: " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            System.out.println("⮞ 전달된 인자: " + args[0]);
        }
    }

    /**
     * @After: 대상 메서드 실행 후 항상 동작
     * - 성공이든 예외든 무조건 실행됨
     * - 주로: 리소스 정리, 종료 로그 등에 사용
     */
    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("📌 [After] 메서드 실행 완료");
    }

    /**
     * @AfterReturning: 메서드가 정상 종료될 경우에만 동작
     * - 반환값을 가로채어 추가 처리 가능
     * - 여기선: 반환값이 Map이면 데이터 추가 가공
     */
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("✅ [AfterReturning] 리턴값: " + result);

        if (result instanceof Map) {
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환값 가공"));
            System.out.println("✅ [AfterReturning] 반환값에 가공 데이터 추가됨");
        }
    }

    /**
     * @AfterThrowing: 메서드 실행 중 예외 발생 시 동작
     * - 예외 정보를 활용하여 오류 로그 남기기 가능
     * - 주로: 예외 알림, 에러 로깅 등에 사용
     */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("❌ [AfterThrowing] 예외 발생!");
        System.out.println("⮞ 예외 메시지: " + exception.getMessage());
    }

    /**
     * @Around: 대상 메서드를 감싸서 실행 전후 모두 처리
     * - 가장 강력한 어드바이스
     * - 용도: 실행 시간 측정, 트랜잭션 제어, 예외 감싸기 등
     */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("🔁 [Around Before] 메서드 실행 직전");

        long start = System.currentTimeMillis(); // 시작 시간 기록
        Object result;

        try {
            result = joinPoint.proceed();  // 실제 대상 메서드 실행
        } catch (Throwable e) {
            System.out.println("⚠️ [Around] 예외 중간 처리 가능: " + e.getMessage());
            throw e; // 예외 다시 던짐 (안 던지면 swallow됨)
        }

        long end = System.currentTimeMillis(); // 종료 시간 기록
        System.out.println("🔁 [Around After] 메서드 실행 완료");
        System.out.println("⏱️ 실행 시간: " + (end - start) + "ms");

        return result; // 원래 결과 반환
    }
}
