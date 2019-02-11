<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Banners</title>
</head>
<link rel="stylesheet" type="text/css" href="resources/css/login.css" media="all">
<body>
<div class="container">

    <form class="center" role="form" method=post action="spring_security_check">
        <div class="dws-input">
            <input type="text" placeholder="Введите логин" name="username">

            <input type="password" placeholder="Введите пароль" name="password"/>
            <input class="butt" type="submit" value="Войти">
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" id="rememberme" name="_spring_security_remember_me"/>Запомнить меня
            </label>
        </div>
        <c:if test="${not empty param.error}">
            <font size="2" color="red"><b>Неправильный логин или пароль</b></font>
        </c:if>
    </form>
</div>
<hr>
<div class="container2">
    <h1>Регистрация</h1>
    <form method=post action="new">
        <div class="dws-input">
            <input type="text" placeholder="Введите никнейм" name="name">
        </div>
        <div>
            <input type="text" placeholder="Введите логин" name="login">
        </div>
        <div>
            <input type="password" placeholder="Введите пароль" name="password"/>
        </div>
        <input class="butt" type="submit" value="Зарегистрироваться">
    </form>
</div>
<div class="message container2">
    <h5 style="color: red">${message}</h5>
</div>
<div>
    <c:if test="${error}">
        ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
    </c:if>
</div>

</body>
</html>
