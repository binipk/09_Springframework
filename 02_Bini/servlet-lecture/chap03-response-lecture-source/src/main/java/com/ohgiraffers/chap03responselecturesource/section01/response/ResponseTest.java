package com.ohgiraffers.chap03responselecturesource.section01.response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/response")  // "/response" 경로로 들어오는 GET 요청 처리
public class ResponseTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        // 1. 응답으로 보낼 HTML을 문자열로 조립
        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<head>")
                .append("<title>응답페이지</title>")  // 웹 브라우저 탭 제목
                .append("</head>")
                .append("<body>")
                .append("<h1>안녕 Servlet Response</h1>")  // 실제 웹페이지 본문
                .append("</body>")
                .append("</html>");

        // 2. 응답의 Content-Type과 인코딩 설정
        // MIME 타입을 text/html로 설정하여 브라우저가 HTML로 인식하게 함
        response.setContentType("text/html");

        // 문자 인코딩은 기본적으로 UTF-8이 되도록 설정
        response.setCharacterEncoding("UTF-8");

        // 위의 두 줄을 한 줄로도 설정 가능
        response.setContentType("text/html; charset=UTF-8");

        // ※ 참고: 톰캣 10 이상부터는 "text/html"만 설정해도 charset=UTF-8이 자동 설정됨

        // 3. 응답 스트림을 통해 클라이언트로 데이터 전송
        PrintWriter printWriter = response.getWriter();  // 텍스트 출력용 스트림 얻기
        printWriter.print(sb);  // HTML 응답 내용 출력
        printWriter.flush();    // 스트림 비우기
        printWriter.close();    // 스트림 닫기
    }
}
