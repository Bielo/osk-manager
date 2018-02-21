<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="commons/header.jsp"/>

<body>

<c:url var="saveTeacher" value="/saveTeacher"/>
<div class="container">
    <div class="title">
        <jsp:include page="commons/logo-left.jsp"/>
        <jsp:include page="commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="commons/bottom-left.jsp"/>
        <div class="center">
            <div class="form">
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
                <jsp:include page="commons/page-back.jsp"/>
            </div>
        </div>
        <jsp:include page="commons/bottom-right.jsp"/>
    </div>
</div>
<jsp:include page="commons/footer.jsp"/>
</body>
</html>
