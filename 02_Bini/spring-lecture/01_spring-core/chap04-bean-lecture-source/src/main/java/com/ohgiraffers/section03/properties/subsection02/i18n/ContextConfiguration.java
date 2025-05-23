package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class ContextConfiguration {

    @Bean
    public MessageSource messageSource() {
        // 메시지 파일을 로드하고, 로케일에 따라 다른 번역을 제공하는 구현체
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        // message_*.properties 파일들의 공통 접두 경로 설정
        // 실제 파일 경로는 src/main/resources/section03/properties/subsection02/i18n/message_ko_KR.properties 등
        messageSource.setBasename("classpath:section03/properties/subsection02/i18n/message");

        // .properties 파일 인코딩을 UTF-8로 지정 (한글/중국어 깨짐 방지)
        messageSource.setDefaultEncoding("UTF-8");

        // 설정한 MessageSource 객체 반환
        return messageSource;
    }
}
