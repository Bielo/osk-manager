<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Formularz dodawania kursanta</title>
    <spring:url var="bootstrapCss" value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${bootstrapCss}">
    <link rel="stylesheet" href="resources/theme1/css/style.css" type="text/css">
</head>

<body>
<c:url var="saveStudent" value="/addStudent"/>
    <div class="container">
        <div class ="title">
            <div class="logo-left">
                <p>Tu będzie logo</p>
            </div>
            <div class="logo-right">
                <p>Tutaj cos bedzie</p>
            </div>
        </div>
        <div class="middle">
            <div class="left">
                <p>lewa czesc strony</p>
            </div>
            <div class="center">
    <form:form id="contact" method="post" modelAttribute="student" action="${saveStudent}">

        <h3>Formularz Kursanta</h3>
        <form:hidden path="id"/>
            <form:input placeholder="imię" path="firstName" required="true"/>
            <form:input placeholder="nazwisko" path="lastName" required="true"/>
            <form:input placeholder="e-mail" path="email" type="email" required="true"/>
            <form:input placeholder="numer telefonu" path="phoneNumber" type="tel" required="true"/>
           <form:input path="birthdate" placeholder="data urodzenia" class="textbox-n" type="text" onfocus="(this.type='date')"  id="date" required="true"/>
            <form:button type="submit" name="submit" class="btn btn-primary submitButton">Dodaj</form:button>
        <%--<input value="Dodaj" type="submit" name="submit">--%>
    </form:form>
            </div>
            <div class="right">
                <p> To jest prawa strona </p>
            </div>
        </div>
        <div class="footer">
            <p> To jest stopka strony</p>
        </div>
    </div>
</body>
</html>
