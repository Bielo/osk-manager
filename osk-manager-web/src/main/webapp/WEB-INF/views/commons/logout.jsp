<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="logo-right">
    <p>Jesteś zalogowany jako: admin</p>

    <spring:url var="logoutUrl" value="/perform_logout"/>

    <form:form method="post" action="${logoutUrl}" class="form-horizontal">
        <button class="buttonLogout" type="submit">
            <i class="icon-power"></i> Wyloguj
        </button>
    </form:form>
</div>