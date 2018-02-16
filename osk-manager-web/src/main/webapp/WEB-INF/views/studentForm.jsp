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
    <link rel="stylesheet" href="../../resources/theme1/css/style.css" type="text/css">
</head>

<body>
<c:url var="saveStudent" value="/addStudent"/>
<div class="container">
    <form:form id="contact" method="post" modelAttribute="student" action="${saveStudent}">

        <h3>Formularz Kursanta</h3>
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
           <form:input type="date" path="birthdate" required="true"/>
        </fieldset>
        <fieldset>
            <input value="Dodaj" type="submit" name="submit">
        </fieldset>
    </form:form>
</div>


</body>
</html>
