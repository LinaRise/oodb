<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <link rel='stylesheet' href='${model["app_path"]}/css/lab10.css'>
    <script src='${model["app_path"]}/js/lab10.js'></script>

    <title>Лабораторная работа 10</title>
</head>

<style>
	#centerLayer {
		position: absolute; /* Абсолютное позиционирование */
		width: 400px; /* Ширина слоя в пикселах */
		height: 300px; /* Высота слоя в пикселах */
		left: 50%; /* Положение слоя от левого края */
		top: 50%; /* Положение слоя от верхнего края */
		margin-left: -200px; /* Отступ слева */
		margin-top: -150px;	/* Отступ сверху */
		/* background: #fc0;  Цвет фона */
		border: solid 1px Seashell; /* Параметры рамки вокруг */
		border-radius: 5px; /* Уголки */
		padding: 10px; /* Поля вокруг текста */
		overflow: auto; /* Добавление полосы прокрутки */
		box-shadow: 0 0 5px ;/* Тень */
	}
</style>
<div class="c-wrapper">

<div id="centerLayer">

    <h2 align="center">БАНК</h2>
    <form method="POST" action="${model['app_path']}/usercheckform" enctype="application/x-www-form-urlencoded">
        <table>
            <tbody>
            <tr>
                <td>
                    <label for="username">Логин</label>
                    <input id="username" name="username" type="text"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="password">Пароль</label>
                    <input id="password" name="password" type="password"/>
                </td>
            </tr>
            </tbody>
        </table>
        <button type="submit"><span>Войти</span></button>
    </form>
</div>
</div>
</body>
</html>