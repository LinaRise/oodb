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
        Автор
    </H2>

    <div>
        (шаблон страницы - author.ftl, контроллер - ru.icmit.oodb.lab12.controller.AuthorController)
    </div>

    <form action='${model["app_path"]}/addauthor' method="post">
        <input type="hidden" name="id" value='${model["author"].id!}'/>

        <div>Фамилия <input type="text" name="lastname" value='${model["author"].lastname!}'/></div>
        <div>Имя <input type="text" name="name" value='${model["author"].name!}'/></div>
        <div>Отчество <input type="text" name="patronymic" value='${model["author"].patronymic!}'/></div>
        <div>Информация <input type="text" name="info" value='${model["author"].info!}'/></div>

        <input type="submit" value="Сохранить"/>

    </form>


    <table>
        <#if model["books"]??>
         <h3>Список книг автора</h3>
            <#list model["books"] as book>

        <thead>
        <th>id</th>
        <th>Название</th>
        <th>УДК</th>
        <th>ЛБС</th>
        <th>Цена</th>
        <th>Дата публикации</th>
        <th>Секция</th>
        </thead>
        <tbody>

		<tr>
            <td>
				<#if book.id??>${book.id}</#if>
            </td>
            <td><#if book.title??>${book.title}</#if></td>
            <td><#if book.UDC??>${book.UDC}</#if></td>
            <td><#if book.LBC??>${book.LBC}</#if></td>
            <td><#if book.price??>${book.price}</#if></td>
            <td><#if book.dateofpublishing??>${book.dateofpublishing?date?string('dd.MM.yyyy')}</#if></td>
            <td><#if (book.sectionstitles.title)??>${book.sectionstitles.title}
            <#else></#if></td>
            <td>
				<#if book.id??>
                    <button
                            onclick="document.location = '${model['app_path']}/deletebook?id=${book.id}'">X
                    </button></#if>
            </td>
        </tr>
            </#list>
        </#if>
    </tbody>
    </table>

    <h3>Добавить новую книгу</h3>
	<#if model["author"].id??>
	<form action='${model["app_path"]}/addbook' method="post">
        <div style="width:30%">
            <input type="hidden" name="id" value='${model["author"].id!}'/>
            <input type="text" name="title" placeholder="Укажите название книги"/>
            <input type="text" name="UDC" placeholder="Укажите  УДК"/>
            <input type="text" name="LBC" placeholder="Укажите  ЛБС"/>
            <input type="text" name="price" placeholder="Укажите  цену"/>
            <input type="date" name="dateofpublishing" placeholder="Укажите дату публикации"/>
            <input type="text" name="sectionstitles_id" placeholder="Введите id секции"/>
        </div>
        <input type="submit" value="Добавить книгу"/>

    </form>
    </#if>
</div>
</body>
</html>