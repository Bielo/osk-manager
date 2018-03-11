<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="../commons/header.jsp"/>

<body>
<c:url var="addDrivingLesson" value="/student/showTeachersForADay/"/>
<div class="container">
    <div class="title">
        <jsp:include page="../commons/logo-left.jsp"/>
        <jsp:include page="../commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="../commons/bottom-left.jsp"/>
        <div class="center">
            <div class="content">
                <c:choose>
                    <c:when test="${!empty date}">
                <form:form class="form" method="post" modelAttribute="date" action="${addDrivingLesson}">
                    <h3>Formularz Planowania Jazd</h3>
                    <form:input path="date" placeholder="Wybierz termin jazdy" class="textbox-n" type="text"
                                onfocus="(this.type='date')" id="date" required="true"/>
                    <form:select path = "teacher">
                        <form:option value = "NONE" label = "Select"/>
                        <form:options items = "${teachers}" itemValue="id"/>
                    </form:select>
                    <form:button type="submit" name="submit" class="btn btn-primary submitButton">Pokaż</form:button>
                </form:form>
                <jsp:include page="../commons/page-back.jsp"/>
                    </c:when>

                    <c:when test="${empty lessons}">
                        Nauczyciel w danym terminie nie ma lekcji
                    </c:when>
                    <c:when test="${!empty lessons}">
                        <table class="tab">
                            <thead>
                            <tr>
                                <th>Instruktor</th>
                                <th>Początek lekcji</th>
                                <th>Koniec lekcji</th>
                                <th>Opcje</th>
                            </tr>
                            </thead>
                            <c:forEach items="${lessons}" var="lesson">
                                <tr>
                                    <td>${lesson.teacher}</td>
                                <td>${lesson.lessonStartTime}</td>
                                <td>${lesson.lessonStopTime}</td>
                                    <td class="noborder">
                                        <div class="option-button">
                                            <spring:url value="/student/lesson/${lesson.id}" var="reserveLesson"/>
                                            <a class="option-link" href='${reserveLesson}'>
                                                <i class="icon-edit"></i>Zapisz się
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>

                </c:choose>
            </div>
        </div>
        <jsp:include page="../commons/bottom-right.jsp"/>
    </div>
    <jsp:include page="../commons/footer.jsp"/>
</div>
</body>
</html>