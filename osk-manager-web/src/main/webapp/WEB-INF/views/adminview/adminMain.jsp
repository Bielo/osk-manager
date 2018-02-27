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
            <div class="content">
                <h3>Panel Administratora</h3>

                <div class="square">
                    <div class="link1"><a class="tilelink" href="<c:url value='admin/addStudent'/>">
                        <i class="icon-user-add"></i></br>
                        Dodaj kursanta
                    </a></div>
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='admin/addTeacher'/>">
                            <i class="icon-user-add-outline"></i></br>
                            Dodaj instruktora
                        </a>
                    </div>
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='admin/showSchedule'/>">
                            <i class="icon-calendar"></i></br>
                            Harmonogram
                        </a>
                    </div>
                </div>
                <div class="square">
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='admin/findStudent'/>">
                            <i class="icon-search"></i></br>
                            Znajdź kursanta
                        </a>
                    </div>
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='admin/findTeacher'/>">
                            <i class="icon-search"></i></br>
                            Znajdź instruktora
                        </a>
                    </div>
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='admin/showStudentss'/>">
                            <i class="icon-users"></i></br>
                            Kursanci
                        </a>
                    </div>
                </div>
                <div class="square">
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='admin/showTeacherss'/>">
                            <i class="icon-users-outline"></i></br>
                            Instruktorzy
                        </a>
                    </div>
                    <div class="link1">
                        <a class="tilelink" href="<c:url value='admin/editPassword'/>">
                            <i class="icon-edit"></i></br>
                            Ustawienia hasła
                        </a>
                    </div>
                </div>
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
