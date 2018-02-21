<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<jsp:include page="commons/header.jsp"/>

<body>
<div class="containter">
    <div class="title">
        <jsp:include page="commons/logo-left.jsp"/>
        <div class="logo-right">
            <p>Tutaj cos bedzie</p>
        </div>
    </div>
    <div class="middle">
        <jsp:include page="commons/bottom-left.jsp"/>
        <div class="center">
            <div class="form">
                <spring:url var="login" value="perform_login"/>
                <form:form class="content" method="post" modelAttribute="login" action="${login}">

                    <h3>Logowanie do Panelu OSK Manager</h3>
                    <form:input placeholder="login" path="username"/>
                    <form:input placeholder="hasło" path="password" type="password"/>
                    <form:button type="submit" name="submit" class="btn btn-primary submitButton">Zaloguj</form:button>
                </form:form>
                <p>Nie pamiętasz hasła?</p>
            </div>
        </div>
        <jsp:include page="commons/bottom-right.jsp"/>
    </div>
</div>
<jsp:include page="commons/footer.jsp"/>
</body>
</html>
