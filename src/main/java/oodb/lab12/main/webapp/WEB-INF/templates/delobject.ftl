<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<link rel='stylesheet' href='${model["app_path"]}/css/lab10.css'>
	<script src='${model["app_path"]}/js/lab10.js'></script>

	<title>Лабораторная работа 12</title>
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
	Библиотека, удаление объектов
</H2>


	<div>
        (шаблон страницы - delobject.ftl, контроллер - ru.icmit.oodb.lab12.controller.DeleteObjectController)
    </div>

	<h3>
		Удаление клиента
	</h3>
	<form method="post" action='${model["app_path"]}/author/delete'>
		ID автора<input name="authorid"/>
		<input type="submit" value="Удалить"/>
	</form>

    <h3>
        Удаление секции
    </h3>
    </h3>
    <form method="post" action='${model["app_path"]}/section/delete'>
        ID секции<input name="sectionid"/>
        <input type="submit" value="Удалить"/>
    </form>


    <h3>
        Удаление книги
    </h3>
    </h3>
    <form method="post" action='${model["app_path"]}/author/deletebook'>
        ID книги<input name="bookid"/>
        <input type="submit" value="Удалить"/>
    </form>


    <h3>
        Удаление всех книг автора
    </h3>
    </h3>
    <form method="post" action='${model["app_path"]}/author/deleteallbooks'>
        ID автора<input name="authorid"/>
        <input type="submit" value="Удалить"/>
    </form>


</div>
</body>
</html>