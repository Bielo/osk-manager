
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="commons/header.jsp"/>

<body>

<h1>Witamy w OSK-MANAGER!</h1>
<p>Studenci</p>
<c:when test="${!empty studentList}">
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.phoneNumber}</td>
            <td>${student.email}</td>
        </tr>
    </c:forEach>
</c:when>

<p>Instruktorzy</p>
<c:when test="${!empty teacherList}">
    <c:forEach items="${teacherList}" var="teacher">
        <tr>
            <td>${teacher.firstName}</td>
            <td>${teacher.lastName}</td>
            <td>${teacher.phoneNumber}</td>
            <td>${teacher.email}</td>
        </tr>
    </c:forEach>
</c:when>

<jsp:include page="commons/footer.jsp"/>
</body>
</html>
