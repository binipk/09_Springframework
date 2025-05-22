package com.ohgiraffers.section01.xmlconfig;

// Spring에서 제공하는 ApplicationContext 인터페이스를 import
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;

// XML 기반 설정을 사용할 수 있게 해주는 구현체인 GenericXmlApplicationContext import
import org.springframework.context.support.GenericXmlApplicationContext;

import java.lang.reflect.Member;

public class Application {

    public static void main(String[] args) {

        // 💡 ApplicationContext는 스프링 IoC 컨테이너이다.
        // XML 설정 파일(spring-context.xml)을 읽어서 내부에 정의된 Bean들을 생성하고 관리한다.
        ApplicationContext applicationContext =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");
        // ※ 위 경로는 resources 폴더 기준 상대 경로이며, 실제로 존재하는 XML 파일이어야 함

        // 💡 스프링 컨테이너에 등록된 모든 Bean의 이름을 배열로 받아온다.
        String[] beanNames = applicationContext.getBeanDefinitionNames();

        // 💡 등록된 Bean들의 이름을 하나씩 출력
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        // 출력 예시 (XML에 등록된 bean이 있다면):
        // beanName = member
        // beanName = org.springframework.context.annotation.internalConfigurationAnnotationProcessor
        // ...등등 (내부 빈도 함께 출력될 수 있음)

        /*1. bean의 id를 이용해서 bean을 가져오는 방법*/
        /*
        MemberDTO member = (MemberDTO) applicationContext.getBean("member");
        System.out.println(member);
        */

        /*2. bean의 클래스 메타 정보를 전달하여 가져오는 방법*/
        /*
        MemberDTO member = applicationContext.getBean(MemberDTO.class);
        System.out.println(member);
        */

        /*3. bean의 id와 클래스 메타정보를 전달하여 가져오는 방법*/
        MemberDTO member = applicationContext.getBean("member", MemberDTO.class);
        System.out.println(member);

    }
}
