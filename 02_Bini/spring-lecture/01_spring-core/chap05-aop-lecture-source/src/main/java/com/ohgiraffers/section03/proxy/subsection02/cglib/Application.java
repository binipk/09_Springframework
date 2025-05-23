package com.ohgiraffers.section03.proxy.subsection02.cglib;


import com.ohgiraffers.section03.proxy.common.OhgiraffersStudents;
import org.springframework.cglib.proxy.Enhancer;

public class Application {

    public static void main(String[] args) {

        /*
        * 2. CGLib 방식
        * Target Object의 타입이 Class여도 가능하다
        * */
        OhgiraffersStudents ohgiraffersStudent = new OhgiraffersStudents();
        Handler handler = new Handler(ohgiraffersStudent);

        OhgiraffersStudents proxy
                = (OhgiraffersStudents) Enhancer.create(OhgiraffersStudents.class, handler);

        proxy.study(16);
    }
}
