<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    // 자바 코드 영역: 과일 배열을 request에 저장
    String[] fruits = {"사과", "바나나", "포도", "복숭아"};
    request.setAttribute("fruitList", fruits);
%>

<html>
<head>
    <title>과일 리스트</title>
</head>
<body>
    <h2> 과일 목록 </h2>
    <ul>
        <%-- JSTL 반목문으로 리스트 출력 --%>
        <c:forEach var="fruit" items="${fuitList}" varStatus="status">
            <li>${status.index + 1}. ${fruit}</li>
        </c:forEach>
    </ul>

    <br/>
    <a href="index.jsp"> <<<<< 돌아가기 </a>
</body>
</html>
