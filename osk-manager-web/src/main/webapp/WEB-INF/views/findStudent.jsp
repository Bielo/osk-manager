<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <title>OSK Manager</title>
</head>
<body>
<h3>Znajdż kursanta</h3>

<spring:url value="findStudent" var="findStudent"/>
<form:form method="post" modelAttribute="searchStudent" action='${findStudent}'>
    <form:label path="firstName">
        Imię
    </form:label>
    <form:input path="firstName"/>

        <form:label path="lastName">
            Nazwisko
        </form:label>
        <form:input path="lastName"/>
    <button class="btn btn-primary" type="submit">
        Znajdź
    </button>

</form:form>
<c:choose>
    <c:when test="${!empty foundStudent}">
    <c:forEach items="${foundStudent}" var="student">
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
            <td>Nie znaleziono</td>
        </tr>
    </c:otherwise>
</c:choose>
</body>
</html>
