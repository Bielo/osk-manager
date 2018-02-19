<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Osk Manager</title>
    <spring:url var="bootstrapCss" value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${bootstrapCss}">
    <link rel="stylesheet" href="resources/theme1/css/style.css" type="text/css">
</head>

<body>
<div class="containter">
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
            <spring:url var="login" value="perform_login"/>
            <form:form id="contact" method="post" modelAttribute="login" action="${login}">

                <h3>Logowanie do Panelu OSK Manager</h3>
                <form:input placeholder="login" path="username"/>
                <form:input placeholder="hasło" path="password" type="password"/>
                <form:button type="submit" name="submit" class="btn btn-primary submitButton">Zaloguj</form:button>
            </form:form>
            <p>Nie pamiętasz hasła?</p>
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
