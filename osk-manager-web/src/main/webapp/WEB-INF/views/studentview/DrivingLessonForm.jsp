<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="../commons/header.jsp"/>

<body>
<c:url var="addDrivingLesson" value="/addDrivingLesson"/>
<div class="container">
    <div class="title">
        <jsp:include page="../commons/logo-left.jsp"/>
        <jsp:include page="../commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="../commons/bottom-left.jsp"/>
        <div class="center">
            <div class="content">
                <form:form class="form" method="post" modelAttribute="drivingLesson" action="${addDrivingLesson}">
                    <h3>Formularz Planowania Jazd</h3>
                    <form:input path="lessonDay" placeholder="Wybierz termin jazdy" class="textbox-n" type="text"
                                onfocus="(this.type='date')" id="date" required="true"/>
                    <form:button type="submit" name="submit" class="btn btn-primary submitButton">Pokaż</form:button>
                </form:form>
                <jsp:include page="../commons/page-back.jsp"/>
            </div>
        </div>
        <jsp:include page="../commons/bottom-right.jsp"/>
    </div>
    <jsp:include page="../commons/footer.jsp"/>
</div>
</body>
</html>