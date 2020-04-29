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
		<li><a href='${model["app_path"]}/author'>Авторы</a></li>
		<li><a href='${model["app_path"]}/section'>Секции</a></li>
		<li><a href='${model["app_path"]}/book'>Книги</a></li>

		<li style="float:right"><a href='${model["app_path"]}/logout'>Выход</a></li>
	</ul>
</div>

<div class="c-wrapper">

<H2>
	БИБЛИОТЕКА
</H2>

	<div>
		<a href='${model["app_path"]}/author'>Авторы</a><br/>
	</div>


	<form action='${model["app_path"]}/authorbylastname' method="post">
		Введите фамилию: <input name="lastname" type="text"/>

		<input type="submit" value="Искать"/>

	</form>

    <form action='${model["app_path"]}/bookbytitle' method="post">
        Введите название книги: <input name="title" type="text"/>

        <input type="submit" value="Искать"/>

    </form>


    <form action='${model["app_path"]}/sectionbytitle' method="post">
        Введите название секции: <input name="title" type="text"/>

        <input type="submit" value="Искать"/>

    </form>


</div>
</body>
</html>