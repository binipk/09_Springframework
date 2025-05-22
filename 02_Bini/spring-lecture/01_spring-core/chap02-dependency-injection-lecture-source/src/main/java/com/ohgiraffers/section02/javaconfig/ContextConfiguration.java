package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 📦 Java 기반 설정 클래스
 * @Configuration : 해당 클래스가 스프링 설정 클래스임을 명시 (Bean 등록용)
 */
@Configuration
public class ContextConfiguration {

    /**
     * 💳 Account 타입의 Bean 등록
     * - 반환 객체: PersonalAccount(구현체)
     * - Bean ID: accountGenerator (메서드 이름 기준)
     */
    @Bean
    public Account accountGenerator() {
        return new PersonalAccount(20, "123-456-7890");
    }

    /**
     * 👤 MemberDTO 타입의 Bean 등록
     * - 내부에서 다른 Bean(accountGenerator)을 호출하여 의존성 주입
     */
    @Bean
    public MemberDTO memberGenerator() {

        /* ✅ 1. 생성자 주입 방식 (추천) */
        return new MemberDTO(
                1,
                "홍길동",
                "010-1234-5678",
                "hong@gmail.com",
                accountGenerator()
        );

        /*
        ✅ 2. Setter 주입 방식 (선택)
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setSequence(1);
        memberDTO.setName("홍길동");
        memberDTO.setPhone("010-1234-5678");
        memberDTO.setEmail("hong@gmail.com");
        memberDTO.setPersonalAccount(accountGenerator());
        return memberDTO;
        */
    }
}
