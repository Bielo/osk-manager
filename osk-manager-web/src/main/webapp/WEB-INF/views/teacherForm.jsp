<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <p>Dodaj instruktora</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="newTeacher" class="form-horizontal">
    <fieldset>
        <legend>Dodaj nowego instruktora</legend>
        <table>
            <tr>
                <td colspan="2">
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="firstName">Imie</label>
                        <div class="col-lg-10">
                            <form:input path="firstName" type="text" class="form:input-large"/>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="lastName">Nazwisko</label>
                        <div class="col-lg-10">
                            <form:input path="lastName" type="text" class="form:input-large"/>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="mobileNumber">Numer Telefonu</label>
                        <div class="col-lg-10">
                            <form:input path="mobileNumber" type="tel" class="form:input-large"/>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="email">Adres e-mail</label>
                        <div class="col-lg-10">
                            <form:input path="email" type="text" class="form:input-large"/>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj"/>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
        </form:form>
</section>
</body>
</html>
