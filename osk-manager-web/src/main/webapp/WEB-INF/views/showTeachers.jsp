<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="commons/header.jsp"/>

<body>
<div class="container">
    <div class="title">
        <jsp:include page="commons/logo-left.jsp"/>
        <jsp:include page="commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="commons/bottom-left.jsp"/>
        <div class="center">
            <div class="content">
                <h4>Instruktorzy</h4>
                <c:choose>
                <c:when test="${!empty teachers}">
                <table class="tab">
                    <thead>
                    <tr>
                        <th>Imię</th>
                        <th>Nazwisko</th>
                        <th>E-mail</th>
                        <th>Telefon</th>
                        <th colspan="2">Opcje</th>
                    </tr>
                    </thead>
                    <c:forEach items="${teachers}" var="teacher">
                        <tr>
                            <td>${teacher.firstName}</td>
                            <td>${teacher.lastName}</td>
                            <td>${teacher.email}</td>
                            <td>${teacher.phoneNumber}</td>
                            <td class="noborder">
                                <div class="option-button">
                                    <spring:url value="/teacher/edit/${teacher.id}" var="studentEditUrl"/>
                                    <a class="option-link" href='${studentEditUrl}'>
                                        <i class="icon-edit"></i>Edytuj
                                    </a>
                                </div>
                            </td>
                            <td class="noborder">
                                <div class="option-button">
                                    <spring:url value="/teacher/delete/${teacher.id}" var="studentDeleteUrl"/>
                                    <a class="option-link" href='${studentDeleteUrl}'>
                                        <i class="icon-user-times"></i>Usuń
                                    </a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <p class="info">Nie ma żadnych instruktorów</p>
                    </c:otherwise>
                    </c:choose>
                </table>
                <jsp:include page="commons/page-back.jsp"/>
            </div>
        </div>
        <jsp:include page="commons/bottom-right.jsp"/>
    </div>
</div>
<jsp:include page="commons/footer.jsp"/>
</body>
</html>
