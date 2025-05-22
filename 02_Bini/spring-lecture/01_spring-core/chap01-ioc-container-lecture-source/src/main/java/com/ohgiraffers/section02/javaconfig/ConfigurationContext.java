package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ✅ @Configuration
 * 이 클래스가 **스프링 설정 클래스**임을 나타냄.
 * - 이 클래스 내부에 정의된 메서드들로 Bean을 등록할 수 있음.
 * - XML 대신 Java 코드로 Bean 설정이 가능하게 해주는 핵심 어노테이션.
 */
@Configuration
public class ConfigurationContext {

    /**
     * ✅ @Bean
     * 이 메서드가 반환하는 객체를 스프링 컨테이너에 **Bean으로 등록**함.
     *
     * - name 속성을 지정하지 않으면 메서드 이름(getMember)이 Bean의 이름이 됨.
     *   (즉, getBean("getMember")으로 꺼낼 수 있음)
     * - name 속성을 지정하면 해당 이름으로 Bean이 등록됨.
     *   (예: getBean("member"))
     *
     * 예시:
     * ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationContext.class);
     * MemberDTO member = context.getBean("member", MemberDTO.class);
     */
    @Bean(name = "member")
    public MemberDTO getMember() {
        // MemberDTO 객체를 생성하여 반환 → 이 객체가 스프링 컨테이너에 등록됨
        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }

}
