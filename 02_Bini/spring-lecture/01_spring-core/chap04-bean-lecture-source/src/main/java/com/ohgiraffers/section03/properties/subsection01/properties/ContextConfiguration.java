package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import com.ohgiraffers.section02.initdestroy.subsection02.annotation.Owner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration  // Spring 설정 클래스임을 명시
@PropertySource("classpath:section03/properties/subsection01/properties/product-info.properties")
// .properties 파일을 읽어오기 위한 설정
public class ContextConfiguration {

    // 붕어빵의 이름을 외부 설정에서 읽어옴 (없으면 "붕어빵" 사용)
    @Value("${bread.crapbread.name:붕어빵}")
    private String name;

    // 붕어빵의 가격을 외부 설정에서 읽어옴 (없으면 0 사용)
    @Value("${bread.crapbread.price:0}")
    private int price;

    @Bean
    public Product crapBread() {
        // 주입된 name, price 값으로 Bread 객체 생성
        return new Bread(name, price, new java.util.Date());
    }

    @Bean
    public Product milk(
            // 딸기우유의 이름, 가격, 용량을 외부 설정에서 읽어옴 (없으면 기본값 사용)
            @Value("${beverage.milk.name:딸기우유}") String name,
            @Value("${beverage.milk.price:1500}") int price,
            @Value("${beverage.milk.capacity:500}") int capacity
    ) {
        // Beverage 객체 생성 후 반환
        return new Beverage(name, price, capacity);
    }

    @Bean
    public Product water(
            // 물의 이름, 가격, 용량을 외부 설정에서 읽어옴 (정확한 키 이름 사용)
            @Value("${beverage.water.name}") String name,
            @Value("${beverage.water.price}") int price,
            @Value("${beverage.water.capacity}") int capacity
    ) {
        // Beverage 객체 생성 후 반환
        return new Beverage(name, price, capacity);
    }

    @Bean
    @Scope("prototype")  // getBean() 호출 시마다 새로운 인스턴스를 생성
    public ShoppingCart cart() {
        // 매번 새로운 장바구니 인스턴스를 반환
        return new ShoppingCart();
    }

    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner() {
        // 가게 주인 객체 반환
        // context 초기화 시 openShop(), 종료 시 closeShop() 자동 호출됨
        return new Owner();
    }
}
