package oodb.lab5;

import com.google.gson.Gson;
import oodb.lab5.classes.Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Database {

  private Gson gson = new Gson();


  private final static String URL = "jdbc:postgresql://localhost/oodb2";
  private final static String USER = "postgres";
  private final static String PASSWORD = "postgres";


  void saveToDB() {
    System.out.println("Сохранение в БД");
    org.postgresql.Driver driver1 = new org.postgresql.Driver();
    try {
      Class.forName(driver1.getClass().getName());

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    final String SQL_INPUT1 = "INSERT INTO authors (author) VALUES (ROW(ROW('Лев', 'Николаевич', 'Толстой'),'Писатель, годы жизни 1828-1910')) returning id";
    final String SQL_INPUT2 = "INSERT INTO authors (author) VALUES (ROW(ROW('Марк', '', 'Зусак'),'Писатель, годы жизни 1975-')) returning id";
    final String SQL_INPUT3 = "INSERT INTO books (book) VALUES (ROW('NOVEl', 'Книжный вор', '23.09.2016', 1243)) returning id";
    final String SQL_INPUT4 = "INSERT INTO books (book) VALUES (ROW('NOVEl','Война и мир','23.09.2018',1000)) returning id";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT1)) {

      ResultSet resultSet = preparedStatement.executeQuery();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
          PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT2)) {;
      ResultSet resultSet = preparedStatement.executeQuery();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT3)) {;
      ResultSet resultSet = preparedStatement.executeQuery();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT4)) {;
      ResultSet resultSet = preparedStatement.executeQuery();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  void update(){
      System.out.println("Обновлние в БД");
      org.postgresql.Driver driver1 = new org.postgresql.Driver();
      try {
        Class.forName(driver1.getClass().getName());

      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      final String SQL_UPDATE1 = "UPDATE authors SET author =  ROW(ROW('Лев', 'Николаевич', 'Толстой'),'Писатель, годы жизни 1828-1910,родился в Красной Поляне') WHERE id=1 returning id";
      final String SQL_UPDATE2 = "UPDATE books SET book.section =  'CLASSIC' WHERE id=2 returning id";
//      final String SQL_UPDATE2 = "INSERT INTO authors (author) VALUES (ROW(ROW('Марк', '', 'Зусак'),'Писатель, годы жизни 1975-')) returning id";
      final String SQL_INPUT3 = "INSERT INTO books (book) VALUES (ROW('NOVEl', 'Книжный вор', '23.09.2016', 1243)) returning id";
      final String SQL_INPUT4 = "INSERT INTO books (book) VALUES (ROW('NOVEl','Война и мир','23.09.2018',1000)) returning id";
      try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
           PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE2)) {

        ResultSet resultSet = preparedStatement.executeQuery();

      } catch (SQLException e) {
        e.printStackTrace();
      }
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE1)) {

      ResultSet resultSet = preparedStatement.executeQuery();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  void searchInDB() {
    System.out.println("Поиск в БД");
    final String SQL_SELECT1 = "SELECT (books.book).title FROM books  WHERE (books.book).price > 1100;";
    final String SQL_SELECT2 = "SELECT * FROM authors";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT1)) {

      String example = "";


      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        example = resultSet.getString("title");
        System.out.println("Поле 'name' содержит: " + example);
      }


    } catch (SQLException e) {
      e.printStackTrace();
    }
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT2)) {

      String example = "";

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        example = resultSet.getString("author");
        System.out.println("Поле 'author' : " + example);
      }
      System.out.println("Поле 'author' : " + example);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }



}