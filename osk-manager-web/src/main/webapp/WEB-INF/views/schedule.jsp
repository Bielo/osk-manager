<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OSK Manager</title>
</head>
<body>
<h1>Harmongoram</h1>

<c:choose>
<c:when test="${!empty lessons}">
<table class="tab">
    <thead>
    <tr>
        <th>Zaplanowane jazdy</th>
    </tr>
    </thead>
    <c:forEach items="${lessons}" var="lesson">
        <tr>
            <td>${lesson}</td>

        </tr>
    </c:forEach>
    </c:when>
    <c:otherwise>
        <p class="info">Nie ma zaplanowanych jazd</p>
    </c:otherwise>
    </c:choose>
</table>
</body>
</html>
