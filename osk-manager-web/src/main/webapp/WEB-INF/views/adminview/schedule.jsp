<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="../commons/header.jsp"/>

<body>
<div class="container">
    <div class="title">
        <jsp:include page="../commons/logo-left.jsp"/>
        <jsp:include page="../commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="../commons/bottom-left.jsp"/>
        <div class="center">
            <div class="content">
                <h4>Harmongoram</h4>
                <c:choose>
                <c:when test="${!empty lessons}">
                <table class="tab">
                    <thead>
                    <tr>
                        <th> Kursant </th>
                        <th> Prowadzący jazdy </th>
                        <th> Data zaplanowanych jazd </th>
                        <th> Godzina rozpoczęcia </th>
                        <th> Godzina zakończenia </th>
                    </tr>
                    </thead>
                    <c:forEach items="${lessons}" var="lesson">
                        <tr>
                            <td>${lesson.studentFirstAndLastName}</td>
                            <td>${lesson.teacherFirstAndLastName}</td>
                            <td>${lesson.lessonDay}</td>
                            <td>${lesson.lessonStartTime}</td>
                            <td>${lesson.lessonStopTime}</td>
                        </tr>
                    </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <p class="info">Nie ma zaplanowanych jazd</p>
                    </c:otherwise>
                    </c:choose>
                </table>
                <jsp:include page="../commons/page-back.jsp"/>
            </div>
        </div>
        <jsp:include page="../commons/bottom-right.jsp"/>
    </div>
</div>
<jsp:include page="../commons/footer.jsp"/>
</body>
</html>
