<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OSK Manager</title>
</head>
<body>
<h1>Lista instruktorów.</h1>

<c:choose>
    <c:when test="${not empty teachers}">
        <c:forEach items="${teachers}" var="teacher">
            <tr>
                <td>${teacher.firstName}</td>
                <td>${teacher.lastName}</td>
                <td>${teacher.email}</td>
                <td>${teacher.phoneNumber}</td>
                <td>
                    <spring:url value="/teacher/edit/${teacher.id}" var="teacherEditUrl"/>
                    <spring:url value="/teacher/delete/${teacher.id}" var="teacherDeleteUrl"/>

                    <button class="btn btn-info" onclick="location.href='${teacherEditUrl}'">
                        Edytuj
                    </button>
                    <button class="btn btn-info" onclick="location.href='${teacherDeleteUrl}'">
                        Usuń
                    </button>
                </td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <tr>
            <td>W szkole nie ma żadnych instruktorów</td>
        </tr>
    </c:otherwise>
</c:choose>
</body>
</html>
