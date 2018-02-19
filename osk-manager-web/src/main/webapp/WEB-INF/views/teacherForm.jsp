
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
<div class="containter">
    <div class="title">
        <jsp:include page="commons/logo-left.jsp"/>
        <jsp:include page="commons/logo-right.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="commons/logo-left.jsp"/>
        <div class="center">
            <form:form id="contact" method="post" modelAttribute="teacher" action="${saveTeacher}">

                <h3>Formularz Instruktora</h3>
                <form:hidden path="id"/>
                <form:input placeholder="imię" path="firstName" required="true"/>
                <form:input placeholder="nazwisko" path="lastName" required="true"/>
                <form:input placeholder="e-mail" path="email" type="email" required="true"/>
                <form:input placeholder="numer telefonu" path="phoneNumber" type="tel" required="true"/>
                <input value="Dodaj" type="submit" name="submit">
            </form:form>
        </div>
        <jsp:include page="commons/logo-right.jsp"/>
    </div>
</div>
<jsp:include page="commons/footer.jsp"/>
</body>
</html>