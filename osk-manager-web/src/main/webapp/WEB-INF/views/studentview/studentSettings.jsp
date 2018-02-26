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
    <div class="title">
        <jsp:include page="../commons/logo-left.jsp"/>
        <jsp:include page="../commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="../commons/bottom-left.jsp"/>
        <div class="center">
            <div class="content center">
                <h3>Ustawienia</h3>

                <div class="square">
                    <div class="link1"><a class="tilelink" href="<c:url value='/student/phonenumberSettings'/>">
                        <i class="icon-edit"></i></br>
                        Edytuj numer
                    </a></div>
                    <div class="link1"><a class="tilelink" href="<c:url value='/student/emailSettings'/>">
                        <i class="icon-edit"></i></br>
                        Edytuj e-mail
                    </a></div>
                </div>
                <jsp:include page="../commons/page-back.jsp"/>
                <c:if test="${not empty info}">
                    <p class="info">${info}</p>
                </c:if>
            </div>
        </div>
        <jsp:include page="../commons/bottom-right.jsp"/>
    </div>
    <jsp:include page="../commons/footer.jsp"/>
</div>
</body>

</html>
