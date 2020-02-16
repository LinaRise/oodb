package oodb.lab7;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ScanDB {

  private static Connection connection;

  HashMap<String, HashSet<String>> getTablesInfo() {
    // Структура для хранения имен таблиц и полей (в HashSet)
    HashMap<String, HashSet<String>> tables = new HashMap<>();

    try (Connection connection = getConnection()) {

//      System.out.println("Список таблиц:");
      List<String> tbls = getTables();
//      tbls.forEach(System.out::println);

      for (String table : tbls) {
        System.out.println("Список полей таблицы " + table + ":");
        List<String> fields = getFields(table);

        HashSet<String> hashSetFields = new HashSet<>();
        fields.forEach(f -> {
          System.out.println(f);
          hashSetFields.add(f);
        });

        tables.put(table, hashSetFields);
      }
      return tables;
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

  private static Connection getConnection() throws SQLException, ClassNotFoundException {
    if (connection != null && !connection.isClosed()) {
      return connection;
    }

    Class.forName("org.postgresql.Driver");
    String dbURL = "jdbc:postgresql://localhost:5432/lab7";
    connection = DriverManager.getConnection(dbURL, "postgres", "postgres");

    return connection;
  }

  List<String> getTables() {
    List<String> tablesList = new ArrayList<>();
    try (Connection connection = getConnection()) {


      PreparedStatement st = connection.prepareStatement(
              "SELECT table_name FROM information_schema.tables " +
                      "WHERE table_type = 'BASE TABLE' AND" +
                      " table_schema NOT IN ('pg_catalog', 'information_schema')");

      ResultSet resultSet = st.executeQuery();

      while (resultSet.next()) {
        String s = resultSet.getString("table_name");
        tablesList.add(s);
      }

      st.close();

    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;

    }
    System.out.println("Список таблиц из БД:");
    tablesList.forEach(System.out::println);
    return tablesList;

  }

  List<String> getFields(String tableName) {
    try (Connection connection = getConnection()) {
      List<String> lst = new ArrayList<>();

      PreparedStatement st = connection.prepareStatement(
              "SELECT a.attname " +
                      "FROM pg_catalog.pg_attribute a " +
                      "WHERE a.attrelid = (SELECT c.oid FROM pg_catalog.pg_class c " +
                      "LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace " +
                      " WHERE pg_catalog.pg_table_is_visible(c.oid) AND c.relname = ? )" +
                      " AND a.attnum > 0 AND NOT a.attisdropped");

      st.setString(1, tableName);
      ResultSet resultSet = st.executeQuery();

      while (resultSet.next()) {
        String s = resultSet.getString("attname");
        lst.add(s);
      }

      st.close();
      return lst;
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

}