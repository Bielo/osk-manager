<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<div class="back">
    <a href="<c:url value='/'/>">
        <i class="icon-left-big"></i>Wróć na poprzednia stronę
    </a>
</div>

<spring:url var="jqueryScript" value="/webjars/jquery/3.2.1/jquery.min.js"/>
<spring:url var="bootstrapScript" value="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"/>

<script type="text/javascript" src="${jqueryScript}"/>
<script type="text/javascript" src="${bootstrapScript}"/>
