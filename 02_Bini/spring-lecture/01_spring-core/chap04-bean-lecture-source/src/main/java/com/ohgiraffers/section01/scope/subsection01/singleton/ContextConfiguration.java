package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.*;

/**
 * Spring 설정 클래스
 * - 상품(Product) 및 장바구니(ShoppingCart)를 Bean으로 등록
 * - 기본 스코프는 싱글톤(Singleton)
 */
@Configuration
public class ContextConfiguration {

    @Bean
    public Product crapBread() {
        System.out.println("붕어빵 생성 시점");
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    /**
     * 쇼핑카트 Bean 등록
     *
     * @DependsOn: 이 Bean을 생성하기 전에 반드시 아래 빈들이 먼저 생성되도록 함
     *             - crapBread, milk, water
     *
     * @Lazy: 이 Bean은 ApplicationContext가 초기화될 때 생성되지 않음!
     *        → Bean이 실제로 "필요해질 때" (예: getBean() 등) 처음으로 생성됨
     *        → 즉, 실행 시점까지 생성을 '지연'시켜 성능 최적화 또는 순환참조 회피 등에 유용
     *
     * @Scope("singleton"): 기본값이지만 명시함. 컨테이너 내에 오직 하나만 생성됨
     */
    @Bean
    @DependsOn({"crapBread", "milk", "water"})
    @Lazy
    @Scope("singleton")
    public ShoppingCart cart() {
        System.out.println("쇼핑 카트 생성 시점");
        return new ShoppingCart();
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
}
