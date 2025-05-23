package com.ohgiraffers.chap02requestlecturesource.section02.formdata;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(value="/formdata")
public class FormDatatest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * HttpServletRequest 객체로부터 요청 시 전달한 값을 getParameter 또는 getParameterValues 메소드로 추출할 수 있다.
         * input 태그의 name 속성 값을 키로 사용하며, 단일 값은 getParameter, 복수 선택 값은 getParameterValues를 사용한다.
         */

        String name = request.getParameter("name");  // 이름
        int age = Integer.parseInt(request.getParameter("age"));  // 나이 (문자열 -> 정수 변환)
        java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));  // 생일 (문자열 -> java.sql.Date 변환)
        String gender = request.getParameter("gender");  // 성별
        String national = request.getParameter("national");  // 국적
        String[] hobbies = request.getParameterValues("hobbies");  // 취미 (복수 선택 가능)

        // 서버 콘솔에 출력
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("birthday = " + birthday);
        System.out.println("gender = " + gender);
        System.out.println("national = " + national);
        System.out.println("hobbies = " + Arrays.toString(hobbies));
    }
}
