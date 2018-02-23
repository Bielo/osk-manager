<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<jsp:include page="commons/header.jsp"/>
<body>
<div class="container">
    <spring:url value="/kursant" var="kursant"/>
    <div class="title">
        <jsp:include page="commons/logo-left.jsp"/>
        <jsp:include page="commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="commons/bottom-left.jsp"/>
        <div class="center">
            <div class="content">
                <h3>Panel Kursanta</h3>

                <div class="square">
                    <div class="link2" class="line"><a class="tilelink" href="<c:url value='/scheduleStudent'/>">
                        <i class="icon-calendar"></i></br></br>
                        Harmonogram
                    </a></div>
                    <div class="link2">
                        <a class="tilelink" href="<c:url value='/setScheduleStudent'/>">
                            <i class="icon-calendar-plus-o"></i></br>
                            Umów się na jazdę
                        </a>
                    </div>

                </div>
                <div class="square">
                    <div class="link2">
                        <a class="tilelink" href="<c:url value='/rateTeacher'/>">
                            <i class="icon-users"></i></br>
                            </br>Oceń instruktora
                        </a>
                    </div>
                    <div class="link2">
                        <a class="tilelink" href="<c:url value='/showSettingsStudent'/>">
                            <i class="icon-wrench-outline"></i></br></br>
                            Ustawienia
                        </a>
                    </div>
                </div>
                <c:if test="${not empty info}">
                    <p class="info">${info}</p>
                </c:if>
            </div>
        </div>
        <jsp:include page="commons/bottom-right.jsp"/>
    </div>
    <jsp:include page="commons/footer.jsp"/>
</div>
</body>

</html>