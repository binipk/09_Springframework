package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Owner {

    @PostConstruct
    public void openShop(){
        System.out.println("사장님이 가게 오픈함, 쇼핑 가능!");
    }

    @PreDestroy
    public void closeShop() {
        System.out.println("사장님이 가게문 닫음, 쇼핑 ㄴㄴ");
    }

}
