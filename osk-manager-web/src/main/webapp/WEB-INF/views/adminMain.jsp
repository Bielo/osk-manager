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
    <div class ="title">
        <jsp:include page="commons/logo-left.jsp"/>
        <jsp:include page="commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="commons/bottom-left.jsp"/>
        <div class="center">
            <form:form id="contact">
                <h3>Panel Administratora</h3>
                <button class="btn btn-primary" onclick="location.href='/student'">
                    Dodaj kursanta
                </button>
                <button class="btn btn-primary" onclick="location.href='/teacher'">
                    Dodaj instruktora
                </button>
                <button class="btn btn-primary" onclick="location.href='/#'">
                    Pokaż statystyki
                </button>
            </form:form>
        </div>
        <jsp:include page="commons/bottom-right.jsp"/>
    </div>
    <jsp:include page="commons/footer.jsp"/>
</div>
</body>

</html>
