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
    <form:form id="contact" method="post" modelAttribute="teacher" action="${saveTeacher}">

        <h3>Formularz Instruktora</h3>
        <form:hidden path="id"/>
        <fieldset>
            <form:input placeholder="imię" path="firstName" required="true"/>
        </fieldset>
        <fieldset>
            <form:input placeholder="nazwisko" path="lastName" required="true"/>
        </fieldset>
        <fieldset>
            <form:input placeholder="e-mail" path="email" type="email" required="true"/>
        </fieldset>
        <fieldset>
            <form:input placeholder="numer telefonu" path="phoneNumber" type="tel" required="true"/>
        </fieldset>
        <fieldset>
            <input value="Dodaj" type="submit" name="submit">
        </fieldset>
    </form:form>
</div>


</body>
</html>