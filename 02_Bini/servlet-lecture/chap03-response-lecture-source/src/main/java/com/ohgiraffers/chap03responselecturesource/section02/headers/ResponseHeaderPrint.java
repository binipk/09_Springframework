package com.ohgiraffers.chap03responselecturesource.section02.headers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(value="/headers")  // "/headers" 경로로 들어오는 GET 요청 처리
public class ResponseHeaderPrint extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 응답의 Content-Type을 설정 (HTML 형식)
        response.setContentType("text/html");

        // 2. (선택사항) 자동 새로고침 설정: 1초마다 페이지를 리프레시 (주석처리됨)
        // response.setHeader("Refresh", "1");

        // 3. 현재 시간 (밀리초)을 가져와서 응답 내용에 포함
        long currentTime = System.currentTimeMillis();

        // 4. HTML 응답 본문 생성
        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<head>")
                .append("<title>응답페이지</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append(currentTime)  // 현재 시간 출력
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        // 5. 클라이언트에 HTML 출력
        PrintWriter out = response.getWriter();  // 출력 스트림 가져오기
        out.println(sb.toString());              // HTML 전송
        out.flush();                             // 스트림 비우기
        out.close();                             // 스트림 닫기

        // 6. 서버 콘솔에 설정된 응답 헤더 이름들 출력 (서버 개발자가 확인용으로 볼 수 있음)
        Collection<String> headerNames = response.getHeaderNames();
        for(String headerName : headerNames) {
            System.out.println(headerName);  // 헤더 이름 출력
        }
    }
}
