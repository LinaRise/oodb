<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <link rel='stylesheet' href='${model["app_path"]}/css/lab10.css'>
    <script src='${model["app_path"]}/js/lab10.js'></script>

    <title>Лабораторная работа 10</title>
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
        Книги
    </H2>


    <div>
        (шаблон страницы - books.ftl, контроллер - ru.icmit.oodb.lab12.controller.BookController)
    </div>

    <table>
        <thead>
        <th>id</th>
        <th>Название</th>
        <th>Автор</th>
        <th>Цена</th>
        <th>Дата публикации</th>
        <th>Секция</th>
        <th>УДК</th>
        <th>ЛБС</th>
        </thead>
        <tbody>
		<#if model["books"]??>
		<#list model["books"] as book>
		<tr>
            <td>
				<#if book.id??>${book.id}</#if>
            </td>
            <td><#if book.title??><a href='${model["app_path"]}/editbook?id=${book.id}'>${book.title}</a></#if></td>
            <td><#if book.author.lastname??><#assign s = book.author.lastname + " " +book.author.name[0]+"."+book.author.patronymic[0]+
            ".">${s}</#if></td>
            <td><#if book.price??>${book.price}</#if></td>
            <td><#if book.dateofpublishing??>${book.dateofpublishing}</#if></td>
            <td><#if (book.sectionstitles.title)??>${book.sectionstitles.title}
            <#else></#if></td>
            <td><#if book.UDC??>${book.UDC}</#if></td>
            <td><#if book.LBC??>${book.LBC}</#if></td>
        </tr>
        </#list>
        </#if>
        </tbody>
    </table>


</div>
</body>
</html>