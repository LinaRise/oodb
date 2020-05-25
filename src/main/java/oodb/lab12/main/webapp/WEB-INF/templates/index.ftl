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
	БИБЛИОТЕКА
</H2>
    <div>
        (шаблон страницы - index.ftl, контроллер - ru.icmit.oodb.lab12.controller.IndexController)
    </div>
    <div>
        <p><strong>Предметная область - библиотека</strong>
        <p><strong>Сущности:</strong>
        <ul>
            <li>Автор</li>
            <li>Книга (принадлежит автору, у атора может быть несколько книг)</li>
            <li>Секция (характеризует книгу, у секции может быть несколько книг)</li>
        </ul>
        <p><strong>Классы:</strong>
        <p>Описание автора<br>
		    @MappedSuperclas <br>
            public class Person {<br>
               @Id<br>
               @GeneratedValue(strategy = GenerationType.IDENTITY)<br>
               Long id;<br>
               String name<br>
               String patronymic;<br>
		       String lastname;<br>
            }<br>

            @Entity<br>
            public class Author extends Person{<br>
               String info;<br>
               @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,orphanRemoval = true)<br>
               List<Book> book = new ArrayList<>();<br>
                    }<br>

        <p>Описание книги<br>
            @Entity<br>
            public class Book {<br>
		         @Id<br>
		         @GeneratedValue(strategy = GenerationType.IDENTITY)<br>
		         Long id;    <br>
		         @ManyToOne<br>
		         @JoinColumn(name = "author_id", nullable = false)<br>
		         Author author;    <br>
		         @ManyToOne<br>
		         @JoinColumn(name = "sectionstitles_id", nullable = true)<br>
		         Sectionstitles sectionstitles;    <br>
		         String title;    <br>
		         String UDC;    <br>
		         String LBC;<br>
		         @Temporal(TemporalType.DATE)<br>
		         Date dateofpublishing;    <br>
		         Double price;    <br>
            }<br>

        <p>Описание секции<br>
            @Entity<br>
            public class Sectionstitles {<br>
                 @Id<br>
                 @GeneratedValue(strategy = GenerationType.IDENTITY)<br>
                 Long id;<br>
                 String title;<br>
                 @OneToMany(mappedBy = "sectionstitles", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)<br>
                 List<Book> books = new ArrayList<>();<br>
              }<br>

        <p><strong>Структура БД:</strong>
             create table author (<br>
                id         bigserial   not null constraint author_pkey primary key,<br>
                lastname   varchar(60) not null,<br>
                name       varchar(60) not null,<br>
                patronymic varchar(60) not null,<br>
                info       varchar(255)<br>
             );<br>

             create table book (<br>
                id                bigserial        not null constraint book_pkey primary key,<br>
                lbc               varchar(20)      not null,<br>
                udc               varchar(20)      not null,<br>
                dateofpublishing  date,<br>
                price             double precision not null,<br>
                title             varchar(255)     not null,<br>
                author_id         bigint                    constraint fk5gbo4o7yxefxivwuqjichc67t references author,<br>
                sectionstitles_id bigint constraint fkj60s520cq7kphsggbgvajyf55 references sectionstitles<br>
             );

             create table sectionstitles (<br>
                id    bigserial   not null constraint sectionstitles_pkey primary key,<br>
                title varchar(60) not null<br>
             );


        <p><strong>Представление:</strong><br>
            @Entity<br>
            public class BookInfo {<br>
               @Id<br>
               private Long id;<br>
               private  String booktitle;<br>
               private String lastname;<br>
               private String name;<br>
               private String patronymic;<br>
               private String sectiontitle;<br>
            }<br>
            <br>
            <br>
             create view bookinfo as  <br>
             SELECT b.id, b.title AS booktitle, a.lastname, a.name, a.patronymic, s2.title AS sectiontitle  <br>
             FROM ((book b  <br>
             LEFT JOIN sectionstitles s2 ON ((b.sectionstitles_id = s2.id)))  <br>
             LEFT JOIN author a ON ((b.author_id = a.id)));  <br>
    </div>





</div>
</body>
</html>