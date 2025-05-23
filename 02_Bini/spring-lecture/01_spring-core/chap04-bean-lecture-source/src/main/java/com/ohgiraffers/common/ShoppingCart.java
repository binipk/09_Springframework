package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 쇼핑 카트를 나타내는 클래스
 * 여러 상품(Product)을 장바구니에 담을 수 있음
 */
public class ShoppingCart {

    // 장바구니에 담긴 상품들을 저장할 리스트
    private final List<Product> items;

    /**
     * 기본 생성자
     * 새로운 비어 있는 리스트로 장바구니 초기화
     */
    public ShoppingCart() {
        items = new ArrayList<>();  // 여기가 핵심 수정 부분!
    }

    /**
     * 상품 리스트를 인자로 받아 초기화할 수 있는 생성자
     * @param items 초기 상품 목록
     */
    public ShoppingCart(List<Product> items) {
        this.items = items;
    }

    /**
     * 장바구니에 상품을 추가하는 메서드
     * @param item 추가할 상품
     */
    public void addItem(Product item) {
        items.add(item);
    }

    /**
     * 장바구니에 담긴 모든 상품을 반환하는 메서드
     * @return 상품 목록
     */
    public List<Product> getItems() {
        return items;
    }
}
