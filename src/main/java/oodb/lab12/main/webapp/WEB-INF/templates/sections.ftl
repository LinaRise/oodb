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
	 Секции
</H2>

 <div>
        (шаблон страницы - sectionbytitle.ftl, контроллер - ru.icmit.oodb.lab12.controller.SectionController,)
    </div>

	<table>
		<thead>
			<th>id</th>
			<th>Секция</th>
		</thead>
		<tbody>
		<#if model["sections"]??>
		<#list model["sections"] as section>
		<tr>
			<td>
				<#if section.id??>${section.id}</#if>
			</td>
			<td><#if section.title??><a href='${model["app_path"]}/addsection?id=${section.id}'>${section.title}</a></#if></td>

		</tr>
		</#list>
		</#if>
	</tbody>
	</table>

</div>
</body>
</html>