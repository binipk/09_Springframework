package com.ohgiraffers.section02.initdestroy.subsection01.java;

import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        // Spring 컨테이너 생성 및 설정 클래스(ContextConfiguration) 등록
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // 상품 Bean들 조회
        Product crapBread = context.getBean("crapBread", Product.class);
        Product milk = context.getBean("milk", Product.class);
        Product water = context.getBean("water", Product.class);

        System.out.println("쇼핑 카트 객체 꺼내기 전");

        // 첫 번째 고객용 장바구니
        ShoppingCart shoppingCart = context.getBean("cart", ShoppingCart.class);
        System.out.println("쇼핑 카트 객체 꺼낸 다음");
        shoppingCart.addItem(crapBread);
        shoppingCart.addItem(milk);
        System.out.println("cart에 담긴 물품: " + shoppingCart.getItems());

        // 두 번째 고객용 장바구니
        ShoppingCart shoppingCart2 = context.getBean("cart", ShoppingCart.class);
        shoppingCart2.addItem(water);
        System.out.println("cart2에 담긴 물품: " + shoppingCart2.getItems());

        // 컨테이너 종료: 이 시점에 destroy 메서드가 호출됨
        ((AnnotationConfigApplicationContext) context).close();
    }
}
