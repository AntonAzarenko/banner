<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="resources/css/start.css" media="all">
<head>
    <title>
        Banners
    </title>
</head>
<body>
<div>
    <div class="title">Баннеры</div>
    <sec:authorize access="!hasRole('ROLE_USER')" var="isUSer">
        <div class="message">
            <li style="padding-top: 15px; padding-bottom: 15px; color: red">
                <c:if test="${empty param.error}">
                    Вы не вошли в приложение
                </c:if>
            </li>

            <h4>${message}</h4>

            <div class="button">
                <a href="login">Войти</a>
            </div>
        </div>
    </sec:authorize>
</div>
<div>
    <div class="container">
        <sec:authorize access="hasRole('ROLE_USER')">
            <div class="exit">
                <a href="logout">Выйти</a>
            </div>
            <div class="user">
                <a href="user">Кабинет пользователя - ${userName}</a>
            </div>
        </sec:authorize>
    </div>
</div>
</body>
</html>
