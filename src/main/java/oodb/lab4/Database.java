package oodb.lab4;

import com.google.gson.Gson;
import oodb.lab4.classes.Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Database {

  private Gson gson = new Gson();


  private final static String URL = "jdbc:postgresql://localhost/oodb";
  private final static String USER = "postgres";
  private final static String PASSWORD = "postgres";


  void saveToDB(Library library) {
    System.out.println("Сохранение в БД");
    org.postgresql.Driver driver1 = new org.postgresql.Driver();
    try {
      Class.forName(driver1.getClass().getName());

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    final String SQL_INPUT1 = "insert into library (json) values ('" + gson.toJson(library) + "') returning id";
    final String SQL_INPUT2 = "insert into library (jsonb) values (cast(? as json)) returning id";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT1)) {


      long start;
      long finish;


      start = System.nanoTime();
      ResultSet resultSet = preparedStatement.executeQuery();
      finish = System.nanoTime();
      System.out.println("Время сохранения в БД - JSON:  " + (finish - start) + " нс.");
      while (resultSet.next()) {
        int i = resultSet.getInt("id");
      }
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT2)) {

      String jsonString = gson.toJson(library);

      long startTime;
      long finishTime;

      preparedStatement.setString(1, jsonString);

      startTime = System.nanoTime();
      ResultSet resultSet = preparedStatement.executeQuery();
      finishTime = System.nanoTime();
      System.out.println("Время сохранения в БД - JSONB:  " + (finishTime - startTime) + " нс.");
      while (resultSet.next()) {
        int i = resultSet.getInt("id");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  void sort() {
    List<String> json = new ArrayList<>();
    List<String> jsonb = new ArrayList<>();
    long start;
    long finish;
    System.out.println("Сортировка");
    final String SQL_SORT1 = "SELECT (json -> 'name') as json FROM library WHERE json iS NOT NULL ORDER by id;";
    final String SQL_SORT2 = "SELECT (jsonb -> 'name') as jsonb FROM library WHERE jsonb IS NOT NULL ORDER by jsonb ASC;";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_SORT1)) {

      String example;

      start = System.nanoTime();
      ResultSet resultSet = preparedStatement.executeQuery();
      finish = System.nanoTime();
      System.out.println("Время сортировки - JSON:  " + (finish - start) + " нс.");

      while (resultSet.next()) {
        example = resultSet.getString("json");
        json.add(example);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_SORT2)) {

      String example;

      start = System.nanoTime();
      ResultSet resultSet = preparedStatement.executeQuery();
      finish = System.nanoTime();
      System.out.println("Время сортировки - JSONB: " + (finish - start) + " нс.");

      while (resultSet.next()) {
        example = resultSet.getString("jsonb");
        jsonb.add(example);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    System.out.println("\nJSON:");
    for (String aJson : json) {
      System.out.println(aJson);
    }
    System.out.println("\nJSONB:");
    for (String aJsonb : jsonb) {
      System.out.println(aJsonb);
    }
  }

  void searchInDB() {
    long start;
    long finish;
    System.out.println("Поиск в БД");
    final String SQL_SELECT1 = "SELECT json -> 'name' as json FROM library";
    final String SQL_SELECT2 = "SELECT jsonb -> 'name' as jsonb FROM library";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT1)) {

      String example = "";

      start = System.nanoTime();
      ResultSet resultSet = preparedStatement.executeQuery();
      finish = System.nanoTime();
      System.out.println("Time searchInDB() - JSON:  " + (finish - start) + " нс.");

      while (resultSet.next()) {
        example = resultSet.getString("json");
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT2)) {

      String example = "";

      start = System.nanoTime();
      ResultSet resultSet = preparedStatement.executeQuery();
      finish = System.nanoTime();
      System.out.println("Время поиска в БД - JSONB: " + (finish - start) + " нс.");

      while (resultSet.next()) {
        example = resultSet.getString("jsonb");
      }
      System.out.println("Поле 'name' содержит: " + example);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  void loadFromDB() {
    long start;
    long finish;
    System.out.println("Считывание из БД");
    final String SQL_SELECT1 = "select json from library";
    final String SQL_SELECT2 = "select jsonb from library";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT1)) {

      String example = "";
      Library library = null;

      start = System.nanoTime();
      ResultSet resultSet = preparedStatement.executeQuery();
      finish = System.nanoTime();
      System.out.println("Время загрузки из БД - JSON:  " + (finish - start) + " нс.");

      while (resultSet.next()) {
        example = resultSet.getString("json");
      }
      library = gson.fromJson(example, Library.class);

    } catch (SQLException e) {
      e.printStackTrace();
    }
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT2)) {

      String example = "";
      Library library = null;

      start = System.nanoTime();
      ResultSet resultSet = preparedStatement.executeQuery();
      finish = System.nanoTime();
      System.out.println("Время загрузки из БД - JSONB: " + (finish - start) + " нс.");

      while (resultSet.next()) {
        example = resultSet.getString("jsonb");
      }
//      library = gson.fromJson(example, Library.class);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}