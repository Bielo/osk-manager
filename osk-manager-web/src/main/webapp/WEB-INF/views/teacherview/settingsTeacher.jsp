<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<jsp:include page="../commons/header.jsp"/>
<body>
<div class="container">
    <spring:url value="/instruktor" var="instruktor"/>
    <div class="title">
        <jsp:include page="../commons/logo-left.jsp"/>
        <jsp:include page="../commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="../commons/bottom-left.jsp"/>
        <div class="center">
            <div class="content">
                <h3>Ustawienia</h3>

                <div class="square">
                    <div class="link2" class="line">
                        <a class="tilelink" href=" <spring:url value="editPhone"/>">
                            <i class="icon-pencil-1"></i></br>
                            Edytuj telefon
                        </a>
                    </div>
                    <div class="link2" class="line">
                        <a class="tilelink" href=" <spring:url value="editEmail"/>">
                            <i class="icon-mail"></i></br>
                            Zmień maila
                        </a>
                    </div>

                    <c:if test="${not empty info}">
                        <p class="info">${info}</p>
                    </c:if>
                </div>
                <jsp:include page="../commons/page-back.jsp"/>
            </div>
        </div>
        <jsp:include page="../commons/bottom-right.jsp"/>
    </div>
    <jsp:include page="../commons/footer.jsp"/>
</div>
</body>
</html>
