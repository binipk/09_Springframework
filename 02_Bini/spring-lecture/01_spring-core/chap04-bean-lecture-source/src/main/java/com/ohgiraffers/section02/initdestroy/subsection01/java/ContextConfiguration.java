package com.ohgiraffers.section02.initdestroy.subsection01.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Spring 설정 클래스
 * - 상품 및 장바구니 Bean 정의
 * - Owner Bean은 init/destroy 메서드를 지정하여 생명주기 제어
 */
@Configuration
public class ContextConfiguration {

    @Bean
    public Product crapBread() {
        System.out.println("붕어빵 생성 시점");
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {
        System.out.println("딸기 우유 생성 시점");
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        System.out.println("물 생성 시점");
        return new Beverage("지리산 절병 암반수", 30000, 500);
    }

    /**
     * 장바구니 Bean
     * - prototype 스코프이므로 getBean() 호출할 때마다 새로운 인스턴스 반환
     */
    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {
        System.out.println("쇼핑 카트 생성 시점");
        return new ShoppingCart();
    }

    /**
     * 가게 주인(Owner) Bean
     * - initMethod: Bean 초기화 시 실행할 메서드
     * - destroyMethod: 컨테이너 종료 시 실행할 메서드
     */
    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner() {
        return new Owner();
    }
}
