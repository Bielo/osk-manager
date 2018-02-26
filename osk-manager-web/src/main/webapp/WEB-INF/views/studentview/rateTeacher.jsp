<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="../commons/header.jsp"/>

<body>
<%--<c:url var="rate" value="/rateTeacher"/>--%>
<div class="container">
    <div class="title">
        <jsp:include page="../commons/logo-left.jsp"/>
        <jsp:include page="../commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="../commons/bottom-left.jsp"/>
        <div class="center">
            <div class="content">
                <form class="form" method="post">
                    <h3>Oceń Instrutkora</h3>
                    <textarea path="teacherRate" placeholder="Wstaw komentarz"></textarea>
                    <div class="stars">
                        <input type="radio" id="star5" name="star" value="5">
                        <label for="star5"></label>
                        <input type="radio" id="star4" name="star" value="4">
                        <label for="star4"></label>
                        <input type="radio" id="star3" name="star" value="3">
                        <label for="star3"></label>
                        <input type="radio" id="star2" name="star" value="2">
                        <label for="star2"></label>
                        <input type="radio" id="star1" name="star" value="1">
                        <label for="star1"></label>
                    </div>
                    <button type="submit" name="submit" class="btn btn-primary submitButton">Oceń</button>
                </form>
                <jsp:include page="../commons/page-back.jsp"/>
            </div>
        </div>
        <jsp:include page="../commons/bottom-right.jsp"/>
    </div>
    <jsp:include page="../commons/footer.jsp"/>
</div>
</body>
</html>