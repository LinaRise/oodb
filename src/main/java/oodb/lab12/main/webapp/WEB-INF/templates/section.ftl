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
        Секция
    </H2>

    <div>
        (шаблон страницы - sectionbytitle.ftl, контроллер - ru.icmit.oodb.lab12.controller.SectionController)
    </div>

    <form action='${model["app_path"]}/addsection' method="post">
        <input type="hidden" name="id" value='${model["section"].id!}'/>

        <div>Секция     <input type="text" name="title" value='${model["section"].title!}'/></div>
        <input type="submit" value="Сохранить"/>

    </form>

    <#--<h3>Список книг автора</h3>-->

    <#--<table>-->
        <#--<thead>-->
        <#--<th>id</th><th>Номер</th>-->
        <#--</thead>-->
        <#--<tbody>-->
		<#--<#if model["books"]??>-->
		<#--<#list model["books"] as book>-->
		<#--<tr>-->
            <#--<td>-->
				<#--<#if book.id??>${book.id}</#if>-->
            <#--</td>-->
            <#--<td><#if book.title??>${book.title}</#if></td>-->
        <#--</tr>-->
        <#--</#list>-->
        <#--</#if>-->
        <#--</tbody>-->
    <#--</table>-->

	<#--<#if model["author"].id??>-->
	<#--<form action='${model["app_path"]}/addbook' method="post">-->
        <#--<input type="hidden" name="id" value='${model["author"].id!}'/>-->
        <#--<input type="text" name="title" placeholder="Укажите название книги"/>-->
        <#--<input type="submit" value="Добавить книгу"/>-->
    <#--</form>-->
    <#--</#if>-->
</div>
</body>
</html>