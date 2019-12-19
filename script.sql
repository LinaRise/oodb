CREATE DATABASE libraries;

CREATE TYPE SECTION AS ENUM
    ( 'SCIENCE',
  'PROSE',
  'CLASSIC',
  'POEMS',
  'JOURNAL',
  'NOVEl');
  
  
 CREATE TABLE AUTHOR (id SERIAL PRIMARY KEY,  name TEXT, patronymic TEXT,surname TEXT, info TEXT);

CREATE TYPE BOOK AS (section SECTION,  title TEXT, dateOfPublishing TEXT, price FLOAT);

CREATE TABLE BOOKINLIBRARY(id SERIAL PRIMARY KEY, book BOOK, library_id INT REFERENCES  LIBRARY(id));
 
CREATE TABLE LIBRARY( id SERIAL PRIMARY KEY, title varchar(100));
 
INSERT INTO LIBRARY (title) VALUES ('Казанская гос библиотека');
INSERT INTO LIBRARY (title) VALUES ('Центральная Казанская библиотека');

INSERT INTO AUTHOR (name, patronymic,surname,info) VALUES ('Лев', 'Николаевич', 'Толстой', 'Писатель, годы жизни 1828-1910');
INSERT INTO AUTHOR (name, patronymic,surname,info) VALUES ('Марк', '', 'Зусак', 'Писатель, годы жизни 1975-');

INSERT INTO BOOKINLIBRARY (book,library_id ) VALUES (ROW('NOVEl','Война и мир',1,'23.09.2018',1000), 1);
 
GRANT SELECT,UPDATE ON TABLE BOOKINLIBRARY TO libraries;