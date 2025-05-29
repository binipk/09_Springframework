package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.SearchCriteria;
import com.ohgiraffers.section01.xml.MenuService;

import java.util.*;

import static com.ohgiraffers.section01.xml.Application.inputSearchCriteria;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SelectBuilderService selectBuilderService = new SelectBuilderService();
        do {
            System.out.println("===== SelectBuilder 서브 메뉴 =====");
            System.out.println("1. SelectBuilder 기본 구문 사용");
            System.out.println("2. SelectBuilder를 이용한 동적 SQL 사용");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 입력 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : selectBuilderService.testSimpleStatement(); break;
                case 2 : selectBuilderService.testDynamicStatement(inputSearchCriteria()); break;
                case 9 : return;
            }

        } while(true);
    }
}
