package com.ohgiraffers.chap02requestlecturesource.section01.querystring;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(value = "/querystring")
public class QueryStringTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
         * HttpServletRequest 객체로부터 요청 시 전달한 값을 getParameter메소드로 추출할 수 있다.
         * 인자로 input 태그의 name속성 값을 문자열 형태로 전달한다.
         * 모든 input 태그의 값을 hashmap으로 관리하고 있으므로 원하는 값을 찾기 위해
         * key 역할을 할 문자열이 필요하다
         */

        // 이름 추출
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        // 나이 추출 및 정수 변환
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("age = " + age);

        // 생일 추출 및 java.sql.Date로 변환
        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("birthday = " + birthday);

        // 성별 추출
        String gender = req.getParameter("gender");
        System.out.println("gender = " + gender);

        // 국적 추출
        String national = req.getParameter("national");
        System.out.println("national = " + national);

        // 취미 배열 추출 (여러 개 선택 가능하므로 getParameterValues 사용)
        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("hobbies = " + Arrays.toString(hobbies));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST 요청 처리 시 필요하면 여기에 작성
    }
}
