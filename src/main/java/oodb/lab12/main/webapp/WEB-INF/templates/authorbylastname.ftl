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
	 Автор
</H2>

    <div>
        (шаблон страницы - authorbylastname.ftl, контроллер - ru.icmit.oodb.lab12.controller.SearchController)
    </div>

    <table>
    <#if model["authors"]??>


		<#list model["authors"] as author>


		<thead>
        <th>id</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>

        </thead>
        <tbody>
		<tr>

            <td><#if author.id??>${author.id}</#if> </td>
            <td><#if author.lastname??>${author.lastname}</#if> </td>
            <td><#if author.name??>${author.name}</#if> </td>
            <td><#if author.patronymic??>${author.patronymic}</#if> </td>

        </tr>
	  </#list>
  </#if>
    </table>




</div>
</body>
</html>