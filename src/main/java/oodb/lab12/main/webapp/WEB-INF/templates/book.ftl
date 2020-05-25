<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <link rel='stylesheet' href='${model["app_path"]}/css/lab10.css'>
    <script src='${model["app_path"]}/js/lab10.js'></script>

    <title>Лабораторная работа 11</title>
</head>
<body>

<div class="menu-bar">
    <ul>
        <li><a class="active" href='${model["app_path"]}'>Главная</a></li>
        <li><a href='${model["app_path"]}/search'>Поиск и создание объектов</a></li>
        <li><a href='${model["app_path"]}/delobject'>Удаление объектов</a></li>
        <li><a href='${model["app_path"]}/author'>Авторы</a></li>
        <li><a href='${model["app_path"]}/section'>Секции</a></li>
        <li><a href='${model["app_path"]}/book'>Книги</a></li>

        <li style="float:right"><a href='${model["app_path"]}/logout'>Выход</a></li>
    </ul>
</div>

<div class="c-wrapper">

    <H2>
        Книга
    </H2>

    <div>
        (шаблон страницы - book.ftl, контроллер - ru.icmit.oodb.lab12.controller.BookController)
    </div>

    <form action='${model["app_path"]}/editbook' method="post">

        <input type="hidden" name="id" value='${model["book"].id!}'/>
        <input type="hidden" name="author_id" value='${model["book"].author.id!}'/>
        <div>Книга
            Название<input type="text" name="title" value='${model["book"].title!}'/>
            Цена<input type="text" name="price" value='${model["book"].price!}'/>
            УДК<input type="text" name="UDC" value='${model["book"].UDC!}'/>
            ЛБС<input type="text" name="LBC" value='${model["book"].LBC!}'/>
            Номер секции <input type="text" name="sectionstitles_id" value='${(model["book"].sectionstitles.id)!""}'/>
            Дата публикации <input type="date" name="dateofpublishing" value='${model["book"].dateofpublishing?string('yyyy-MM-dd')}'/>

        </div>
        <input type="submit" value="Сохранить"/>

    </form>