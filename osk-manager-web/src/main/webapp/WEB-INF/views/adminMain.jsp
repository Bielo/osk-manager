<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<jsp:include page="commons/header.jsp"/>

<body>
<%--
dodaj kursanta,
dodaj instruktora, t
abelka ze wszystkimi jazdami z wybranego dnia,
zaloz konto kursantowi/instruktorowi (dopiero po skonfigurowaniu spring security)
--%>
<div class="container">
    <div class="title">
        <jsp:include page="commons/logo-left.jsp"/>
        <jsp:include page="commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="commons/bottom-left.jsp"/>
        <div class="center">
            <form:form id="contact">
                <h3>Panel Administratora</h3>
                <div class="square">
                    <div class="link1"><a class="tilelink" href="<c:url value='/addStudent'/>">
                        <i class="icon-user-plus"></i></br>
                        Dodaj kursanta
                    </a></div>
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='/addTeacher'/>">
                            <i class="icon-user-add"></i></br>
                            Dodaj instruktora
                        </a>
                    </div>
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='/#'/>">
                            <i class="icon-calendar"></i></br>
                            Harmonogram
                        </a>
                    </div>
                </div>
                <div class="square">
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='/#'/>">
                            <i class="icon-search"></i></br>
                            Znajdź kursanta
                        </a>
                    </div>
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='/#'/>">
                            <i class="icon-search"></i></br>
                            Znajdź instruktora
                        </a>
                    </div>
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='/#'/>">
                            <i class="icon-users"></i></br>
                            Pokaż kursantów
                        </a>
                    </div>
                </div>
                <div class="square">
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='/#'/>">
                            <i class="icon-users-outline"></i></br>
                            Pokaż instruktorów
                        </a>
                    </div>
                </div>
            </form:form>
        </div>
        <jsp:include page="commons/bottom-right.jsp"/>
    </div>
    <jsp:include page="commons/footer.jsp"/>
</div>
</body>

</html>
