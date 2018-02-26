<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="../commons/header.jsp"/>

<body>
<c:url var="saveStudent" value="/saveStudent"/>
<div class="container">
    <div class="title">
        <jsp:include page="../commons/logo-left.jsp"/>
        <jsp:include page="../commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="../commons/bottom-left.jsp"/>
        <div class="center">
            <div class="content">
                <form:form class="form" method="post" modelAttribute="student" action="${saveStudent}">

                    <h3>Formularz Kursanta</h3>
                    <form:hidden path="id"/>
                    <form:input placeholder="imię" path="firstName" required="true"/>
                    <form:input placeholder="nazwisko" path="lastName" required="true"/>
                    <form:input placeholder="e-mail" path="account.email" type="email" required="true"/>
                    <form:input placeholder="password" type="password" path="account.password" required="true"/>
                    <form:input placeholder="numer telefonu" path="phoneNumber" type="tel" required="true"/>
                    <form:input path="birthdate" placeholder="data urodzenia" class="textbox-n" type="text"
                                onfocus="(this.type='date')" id="date" required="true"/>
                    <form:button type="submit" name="submit" class="btn btn-primary submitButton">Dodaj</form:button>
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
