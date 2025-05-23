package com.ohgiraffers.section01.scope.subsection02.prototype;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.*;

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

    @Bean
    @Scope("prototype")  // getBean() 호출 시마다 새로운 인스턴스 생성
    public ShoppingCart cart() {
        System.out.println("쇼핑 카트 생성 시점");
        return new ShoppingCart();
    }
}
