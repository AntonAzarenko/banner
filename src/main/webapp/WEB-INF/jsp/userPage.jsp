<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<link rel="stylesheet" type="text/css" href="resources/css/userpage.css" media="all">
<head>
    <title>Banners</title>
</head>

<body>
<h1>Личный кабинет</h1>
<hr>
<div class="container">
    <div class="link">
        <li><a href="home">Главная</a></li>
    </div>
    <div class="link">
        <li><a href="edit">Управление</a></li>
    </div>
    <table border="1" cellpadding="7" cellspacing="0">
        <c:forEach items="${images}" var="image">
            <tr>
                <th>
                    <div>${image.name}</div>
                    <img src="${path}${image.name}" width="400" height="341"/>
                </th>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
