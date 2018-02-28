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
                    <form:button type="submit" name="submit" class="btn btn-primary submitButton">Pokaż</form:button>
                </form:form>
                <jsp:include page="../commons/page-back.jsp"/>
                    </c:when>
                    <c:when test="${!empty lessons}">
                        Tu wyświetlą się lekcje
                    </c:when>
                    <c:when test="${empty lessons}">
                        Nie ma lekcji w wybranym terminie
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