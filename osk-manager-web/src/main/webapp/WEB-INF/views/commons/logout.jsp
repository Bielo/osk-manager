<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="logo-right">
    <p>Jesteś zalogowany jako: admin</p>

    <spring:url var="logoutUrl" value="/perform_logout"/>

    <form:form method="post" action="${logoutUrl}" class="form-horizontal">
        <button class="buttonLogout" type="submit">
            Wyloguj
        </button>
    </form:form>
</div>