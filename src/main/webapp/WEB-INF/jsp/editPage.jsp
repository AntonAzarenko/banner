<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<link rel="stylesheet" type="text/css" href="resources/css/userpage.css" media="all">

<head>
    <title>Banners</title>
</head>
<body>
<h1>Страница редактирования</h1>
<div class="container">
    <div>
        <a href="user">Страница пользователя</a>
        <hr>
        <h1>Добавить баннер</h1>
        <form method="post" action="upload" enctype="multipart/form-data" multiple="true">
            <input type="file" value="Выберите картинку" accept="image/*" name="file">
            <div class="button">
                <input type="submit" value="загрузить">
            </div>
        </form>
    </div>
    <div class="table">
        <table width="100%" border="1" cellpadding="7" cellspacing="2">
            <tr class="tr">
                <th>Имя баннера</th>
                <th width="150" height="50">баннер</th>
                <th>Редактировать</th>
                <th>Удалить</th>
            </tr>
            <c:forEach items="${images}" var="image">
                <tr>
                    <th>${image.name}</th>
                    <th><img src="${path}${image.name}" width="140" height="48"/></th>
                    <th>
                        <form method="post" action="update" enctype="multipart/form-data" multiple="true">
                            <input type="file" value="Выберите картинку" accept="image/*" name="file">
                            <div class="button">
                                <input type="text" hidden="hidden" name="id" value="${image.id}">
                                <input type="submit" value="Обновить баннер">
                            </div>
                        </form>
                    </th>
                    <th>
                        <form method="post" action="remove">
                            <a>
                                <input type="text" hidden="hidden" name="id" value="${image.id}">
                                <button type="submit">Удалить</button>
                            </a>
                        </form>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
