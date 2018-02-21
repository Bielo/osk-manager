<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<head>
    <meta charset="UTF-8">
    <title>Osk Manager</title>
    <spring:url var="bootstrapCss" value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <spring:url var="styleCSS" value="/resources/theme1/css/style.css"/>
    <spring:url var="fontello" value="/resources/theme1/fontello/css/fontello.css"/>
    <link rel="stylesheet" href="${bootstrapCss}">
    <link rel="stylesheet" href="${styleCSS}" type="text/css">
    <link rel="stylesheet" href="${fontello}">
</head>