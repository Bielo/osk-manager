<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="logo-right">

    <p>Jesteś zalogowany jako:<i class="icon-user"></i> <%=request.getUserPrincipal().getName()%></p>
    <spring:url var="logoutUrl" value="/perform_logout"/>

    <form:form method="post" action="${logoutUrl}" class="form-horizontal">
        <button class="buttonLogout" type="submit">
            <i class="icon-power"></i> Wyloguj
        </button>
    </form:form>
</div>