<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>EL & JSTL 건물 짓고 부수기 게임</title>
    </head>
    <body>
        <h2>EL Test</h2>
        <c:set var="name" value="Bini" />
        <p>이름: ${name}</p>

        <h2>조건문</h2>
        <c:if test="${name == 'Bini'}">
            <p>안녕 Bini!</p>
        </c:if>
    </body>
</html>