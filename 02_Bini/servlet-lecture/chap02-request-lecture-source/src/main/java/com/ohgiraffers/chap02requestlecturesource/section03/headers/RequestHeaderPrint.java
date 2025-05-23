package com.ohgiraffers.chap02requestlecturesource.section03.headers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(value = "/headers") // "/headers" 주소로 GET 요청이 오면 이 서블릿이 처리함
public class RequestHeaderPrint extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 클라이언트가 보낸 요청 헤더의 이름들을 가져옴 (key 목록)
        Enumeration<String> headerNames = request.getHeaderNames();

        // 모든 헤더 이름을 순회하면서 출력
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();  // 다음 헤더 이름 가져오기
            System.out.println(headerName);  // 헤더 이름 출력
        }

        // 아래는 자주 사용되는 대표적인 요청 헤더들을 개별적으로 출력하는 코드

        System.out.println("accept : " + request.getHeader("accept"));  // 클라이언트가 처리 가능한 MIME 타입
        System.out.println("accept-encoding : " + request.getHeader("accept-encoding"));  // 클라이언트가 지원하는 압축 방식
        System.out.println("accept-language : " + request.getHeader("accept-language"));  // 선호하는 언어
        System.out.println("connection : " + request.getHeader("connection"));  // 연결 관리 옵션
        System.out.println("host : " + request.getHeader("host"));  // 요청을 보낸 호스트 이름 및 포트
        System.out.println("referer : " + request.getHeader("referer"));  // 이전 페이지 URL
        System.out.println("sec-fetch-dest : " + request.getHeader("sec-fetch-dest"));  // 요청 리소스의 의도된 대상
        System.out.println("sec-fetch-mode : " + request.getHeader("sec-fetch-mode"));  // 요청 모드 (cors, navigate 등)
        System.out.println("sec-fetch-site : " + request.getHeader("sec-fetch-site"));  // 요청 출처 (same-origin, cross-site 등)
        System.out.println("sec-fetch-user : " + request.getHeader("sec-fetch-user"));  // 유저 제스처 유무
        System.out.println("cache-control : " + request.getHeader("cache-control"));  // 캐시 제어 지시자
        System.out.println("upgrade-insecure-requests : " + request.getHeader("upgrade-insecure-requests"));  // HTTPS로 업그레이드 요구 여부
        System.out.println("user-agent : " + request.getHeader("user-agent"));  // 클라이언트 브라우저 정보
    }
}
