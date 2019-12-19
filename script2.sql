CREATE TYPE SECTION AS ENUM
    ( 'SCIENCE',
  'PROSE',
  'CLASSIC',
  'POEMS',
  'JOURNAL',
  'NOVEl');
  
CREATE TYPE person AS (
	name character varying (40),
	patronymic character varying (40),
	surname character varying (40)

);
CREATE TYPE author AS (
	author person,
	info TEXT
);


CREATE TYPE book AS (
	section SECTION,  
	title TEXT, 
	dateOfPublishing TEXT, 
	price FLOAT
);


CREATE TABLE authors (id SERIAL PRIMARY KEY,  author author);

CREATE TABLE library( id SERIAL PRIMARY KEY, title varchar(100));

CREATE TABLE books(id SERIAL PRIMARY KEY, book book)

CREATE TABLE booksInLibraries(  id SERIAL PRIMARY KEY, books_id INTEGER REFERENCES books(id), library_id INTEGER REFERENCES library(id));

CREATE TABLE booksAndAuthors(  id SERIAL PRIMARY KEY, books_id INTEGER REFERENCES books(id), author_id INTEGER REFERENCES authors(id));


INSERT INTO LIBRARY (title) VALUES ('Казанская гос библиотека');
INSERT INTO LIBRARY (title) VALUES ('Центральная Казанская библиотека');

INSERT INTO authors (author) VALUES (ROW(ROW('Лев', 'Николаевич', 'Толстой'),'Писатель, годы жизни 1828-1910'));

INSERT INTO authors (author) VALUES (ROW(ROW('Марк', '', 'Зусак'),'Писатель, годы жизни 1975-'));

INSERT INTO books (book) VALUES (ROW('NOVEl','Война и мир','23.09.2018',1000));

INSERT INTO books (book) VALUES (ROW('NOVEl', 'Книжный вор', '23.09.2016', 1243));

INSERT INTO booksInLibraries (books_id,library_id ) VALUES (1,1);

INSERT INTO booksAndAuthors (books_id,author_id) VALUES (1,1);





