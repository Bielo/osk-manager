<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: gryzi--%>
  <%--Date: 20.02.2018--%>
  <%--Time: 18:18--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>OSK Manager</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Lista kursantów.</h1>--%>


<%--</body>--%>
<%--</html>--%>




<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="commons/header.jsp"/>

<body>
<c:url var="saveStudent" value="/saveStudent"/>
<div class="container">
    <div class="title">
        <jsp:include page="commons/logo-left.jsp"/>
        <jsp:include page="commons/logout.jsp"/>
    </div>
    <div class="middle">
        <jsp:include page="commons/bottom-left.jsp"/>
        <div class="center">
            <div class="form">
                <c:choose>
                    <c:when test="${!empty students}">
                        <c:forEach items="${students}" var="student">
                            <tr>
                                <td>${student.firstName}</td>
                                <td>${student.lastName}</td>
                                <td>${student.email}</td>
                                <td>${student.phoneNumber}</td>
                                <td>${student.birthdate}</td>
                                <td>
                                        <spring:url value="/student/edit/${student.id}" var="studentEditUrl"/>
                                        <spring:url value="/student/delete/${student.id}" var="studentDeleteUrl"/>

                                        <button class="btn btn-info" onclick="location.href='${accountEditUrl}'">
                                        Edytuj
                                        </button>
                                        <button class="btn btn-info" onclick="location.href='${studentDeleteUrl}'">
                                        Usuń
                                        </button>
                                </td>
                                <br>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td>Nie ma żadnych kursantów</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <jsp:include page="commons/bottom-right.jsp"/>
    </div>
</div>
<jsp:include page="commons/footer.jsp"/>
</body>
</html>

