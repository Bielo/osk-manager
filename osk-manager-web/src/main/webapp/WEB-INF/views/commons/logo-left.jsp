<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="logo-left">
    <spring:url var="logo" value="/resources/theme1/fot/logo.png"/>
    <a href="<c:url value='/'/>"><img src="${logo}" alt="logo" align="left"></a>
</div>