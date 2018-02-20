<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: gryzi
  Date: 20.02.2018
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OSK Manager</title>
</head>
<body>
<h1>Lista kursantów.</h1>

<c:choose>
    <c:when test="${!empty students}">
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.email}</td>
                <td>${student.phoneNumber}</td>
                <td>${student.birthdate}</td>
                <td>
                    <%--<spring:url value="/account/edit/${student.id}" var="studentEditUrl"/>--%>
                    <%--<spring:url value="/account/delete/${student.id}" var="studentDeleteUrl"/>--%>

                    <%--<button class="btn btn-info" onclick="location.href='${accountEditUrl}'">--%>
                        <%--<spring:message code="account.list.action.edit"/>--%>
                    <%--</button>--%>
                    <%--<button class="btn btn-info" onclick="location.href='${accountDeleteUrl}'">--%>
                        <%--<spring:message code="account.list.action.delete"/>--%>
                    <%--</button>--%>
                </td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <tr>
            <td>Nie ma żadnych kursantów</td>
        </tr>
    </c:otherwise>
</c:choose>
</body>
</html>
