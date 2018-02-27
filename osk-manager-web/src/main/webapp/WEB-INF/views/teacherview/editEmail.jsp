<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="../commons/header.jsp"/>

<body>
<c:url var="save" value="/teacher/saveEmail"/>
<div class="containter">
    <div class="title">
        <jsp:include page="../commons/logo-left.jsp"/>
        <jsp:include page="../commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="../commons/bottom-left.jsp"/>
        <div class="center">
            <div class="form">
                <form:form class="content" method="post" modelAttribute="account" action="${save}">
                    <h3>Zmień adres e-mail</h3>
                    <form:hidden path="id"/>
                    <form:input placeholder="e-mail" path="email" type="email" required="true"/>
                    <form:button type="submit" name="submit"
                                 class="btn btn-primary submitButton">Zapisz</form:button>
                </form:form>

                <jsp:include page="../commons/page-back.jsp"/>

            <c:if test="${not empty info}">
                <p class="info">${info}</p>
            </c:if>
    </div>
</div>
<jsp:include page="../commons/bottom-right.jsp"/>
</div>
</div>
<jsp:include page="../commons/footer.jsp"/>
</body>
</html>